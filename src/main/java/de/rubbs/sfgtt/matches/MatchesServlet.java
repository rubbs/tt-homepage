package de.rubbs.sfgtt.matches;


import au.com.bytecode.opencsv.CSVReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import de.rubbs.sfgtt.db.Match;
import de.rubbs.sfgtt.db.OfyService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Handle file uploads
 * Created by ruben on 28.12.15.
 */
@Slf4j
public class MatchesServlet extends HttpServlet {

    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private Random rand = new Random();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String key = req.getParameter("blob-key");

        if (key != null) {
            BlobKey blobKey = new BlobKey(key);

            //TODO parse file
            BlobstoreInputStream is = new BlobstoreInputStream(blobKey);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "ISO-8859-15"));
            CSVReader csvReader = new CSVReader(bufferedReader, ';');

            // read headline
            if (null == csvReader.readNext()) {
                log.error("empty csv file");
                return;
            }

            // delete all matches from datastore
            List<Match> matches = OfyService.ofy().load().type(Match.class).list();
            OfyService.ofy().delete().entities(matches).now();


            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {

                Match match = new Match(nextLine);
                match.setId(System.currentTimeMillis());

                //write match to datastore
                OfyService.ofy().save().entity(match).now();
            }
            //blobstoreService.serve(blobKey, resp);

            resp.sendRedirect("/#/spielplan");  // redirect to matches view
        } else {
            //return list of matches
            List<Match> matches = OfyService.ofy().load().type(Match.class).list();
            ObjectMapper om = new ObjectMapper();
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().print(om.writeValueAsString(matches));
        }


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("received new data...");

        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("myFile");

        if (blobKeys == null || blobKeys.isEmpty()) {
            log.error("no file to upload");
            resp.sendRedirect("/");
        } else {
            log.info("redirect to parsing servlet");
            resp.sendRedirect("/api/matches?blob-key="
                    + blobKeys.get(0).getKeyString());
        }


    }
}

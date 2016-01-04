package de.rubbs.sfgtt.matches;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ruben on 28.12.15.
 */
@Slf4j
public class MatchesServlet extends HttpServlet {

    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // check if initial request
        if(req.getParameter("init") != null){
            // get blobstore key
            resp.getWriter().println(blobstoreService.createUploadUrl("/upload"));
            return;
        }


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException {
        log.info("received new data...");

        String file = req.getParameter("file");

        ObjectMapper om = new ObjectMapper();
        log.info(om.writeValueAsString(req.getParameterMap()));

        if(file == null){
            log.error("no file parameter, no new matches");
        }

        log.info(file);
    }
}

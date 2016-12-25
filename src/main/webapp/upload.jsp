<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>


<html>
    <head>
    <meta http-equiv="Content-Type" content="text/csv; charset=ISO-8859-1">
        <title>Upload Test</title>
    </head>
    <body>
    <h2>Spielplan hochladen</h2>
        <form action="<%= blobstoreService.createUploadUrl("/api/matches") %>" method="post" enctype="multipart/form-data">
            <input type="text" name="foo">
            <input type="file" name="myFile">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
<% @ Page import = "Java. SQL. *" %>
<% @ Page import = "Java. util. *" %>
<% @ Page import = "Java. Io. *" %>
<% @ Page import = "net. SF. jasperreports. Engine. jasperfillmanager" %>
<% @ Page import = "net. SF. jasperreports. Engine. jasperprint" %>
<% @ Page import = "net. SF. jasperreports. Engine. jrexception" %>
<% @ Page import = "net. SF. jasperreports. Engine. jasperrunmanager" %>
<%
String rowid = "1"; // initialize the variable
Connection conn = drivermanager. getconnection ("proxool. test"); // connect to the database from the data source
// Load the Jasper file application
File exe_rpt = new file (application. getrealpath ("/reports/test. Jasper "));
// Rowid is the name of the ireport variable $ P {rowid }.
Map parameters = new hashmap ();
Parameters. Put ("rowid", rowid );
Try {
// Fill
Jasperprint = jasperfillmanager. fillreport (exe_rpt.getpath (), parameters, Conn );

// Generate PDF
Byte [] bytes = jasperrunmanager. runreporttopdf (exe_rpt.getpath (), parameters, Conn );

Response. setcontenttype ("application/pdf ");
Response. setcontentlength (bytes. Length );
Servletoutputstream ouputstream = response. getoutputstream ();
Ouputstream. Write (bytes, 0, bytes. Length );
Ouputstream. Flush ();
Ouputstream. Close ();
Conn. Close ();
} Catch (jrexception ex ){
Out. Print ("Jasper output error:" + ex. getmessage ());
}
%>

}
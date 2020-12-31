<% @ Page import = "Java. SQL. *" %>
<% @ Page import = "Java. util. *" %>
<% @ Page import = "Java. Io. *" %>
<% @ Page import = "net. SF. jasperreports. Engine. jasperfillmanager" %>
<% @ Page import = "net. SF. jasperreports. Engine. jasperprint" %>
<% @ Page import = "net. SF. jasperreports. Engine. jrexception" %>
<% @ Page import = "net. SF. jasperreports. Engine. jrexporterparameter" %> // Excel
<% @ Page import = "net. SF. jasperreports. Engine. Export. jrxlsexporterparameter" %> // Excel
<% @ Page import = "net. SF. jasperreports. Engine. Export. jrxlsexporter" %> // Excel
<%
String rowid = "1 ";
Connection conn = drivermanager. getconnection ("proxool. test ");
 
// Load the Jasper file application
File exe_rpt = new file (application. getrealpath ("/EXCEL/test_excel.jasper "));

// Rowid is the name of the ireport variable $ P {rowid }.
Map parameters = new hashmap ();
Parameters. Put ("rowid", rowid );

Try {
 
// Fill
Jasperprint = jasperfillmanager. fillreport (exe_rpt.getpath (), parameters, Conn );

// Excel output
Bytearrayoutputstream ostream = new bytearrayoutputstream ();

Jrxlsexporter exporter = new jrxlsexporter ();

Exporter. setparameter (jrexporterparameter. jasper_print, jasperprint );
Exporter. setparameter (jrexporterparameter. output_stream, ostream );
Exporter. setparameter (jrxlsexporterparameter. is_remove_empty_space_between_rows, Boolean. True); // Delete the bottom empty row of the record
Exporter. setparameter (jrxlsexporterparameter. is_one_page_per_sheet, Boolean. False); // Delete redundant columnheader
Exporter. setparameter (jrxlsexporterparameter. is_white_page_background, Boolean. False); // display the border
Exporter. exportreport ();

Byte [] bytes = ostream. tobytearray ();

If (Bytes! = NULL & bytes. length> 0 ){
Response. Reset ();
Response. setcontenttype ("application/vnd. MS-excel ");
Response. setcontentlength (bytes. Length );
Servletoutputstream ouputstream = response. getoutputstream ();
Ouputstream. Write (bytes, 0, bytes. Length );
Ouputstream. Flush ();
Ouputstream. Close ();

} Else {
Out. Print ("bytes were null! ");
}
Conn. Close ();
} Catch (jrexception ex ){
Out. Print ("Jasper output error:" + ex. getmessage ());
}
%>
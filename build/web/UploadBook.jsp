<%-- 
    Document   : UploadBook
    Created on : 2015-11-12, 14:02:34
    Author     : gy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PPT上传</title>
    </head>
    <body>
        欢迎您，${user.loginname}  <br>  
        <div>
            <form action="UploadServlet" method="post" enctype="multipart/form-data">  
                选择 PPT:<input type="file" name="key" />
                介绍:<input type="text" name="introduct"/>
            <input type="submit" value="上传" />  
        </div>
    </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib tagdir="/WEB-INF/tags" prefix="sb" %>

<!doctype html>
<html lang=''>
<head>
   <meta name="viewport" content="width=device-width, initial-scale=1">
   
   <link rel="stylesheet" href="/resources/css/styles2.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script type="text/javascript" src="resources/js/script2.js"></script>
   
   <title>CSS MenuMaker</title>
</head>
<body>

<div id='cssmenu'>
<ul>
   <li><a href='#'>Home</a></li>
   <li class='active'><a href='#'>Products</a>
      <ul>
         <li><a href='#'>Product 1</a>
            <ul>
               <li><a href='#'>Sub Product</a></li>
               <li><a href='#'>Sub Product</a></li>
            </ul>
         </li>
         <li><a href='#'>Product 2</a>
            <ul>
               <li><a href='#'>Sub Product</a></li>
               <li><a href='#'>Sub Product</a></li>
            </ul>
         </li>
      </ul>
   </li>
   <li><a href='#'>About</a></li>
   <li><a href='#'>Contact</a></li>
</ul>
</div>

</body>
<html>

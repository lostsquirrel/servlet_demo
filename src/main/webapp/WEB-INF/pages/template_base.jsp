<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="templates" uri="http://tags.app.com/templates/1.0"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<templates:block name="title"/>
</title>
	<style type="text/css" src="globle.css"></style>
	<templates:block name="style"/>
	
	<script type="text/javascript" src="jquery.min.js"></script>
	<templates:block name="script"/>
</head>
<body>
	<templates:block name="content"/>
	<templates:block name="script_bottom"/>
</body>
</html>
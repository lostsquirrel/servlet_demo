<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="templates" uri="http://tags.app.com/templates/1.0"%>

<templates:override name="title">
	Template Test for Title
</templates:override>
<templates:override name="style">
	<style type="text/css" src="item.css"></style>
</templates:override>
<templates:override name="script">
	<script type="text/javascript" src="item.js"></script>
</templates:override>
<templates:override name="content">
	Template Test for Content!
</templates:override>
<templates:override name="script_bottom">
	<script type="text/javascript" >
	alert('finish');
	</script>
</templates:override>
<jsp:include page="/WEB-INF/pages/template_base.jsp" />

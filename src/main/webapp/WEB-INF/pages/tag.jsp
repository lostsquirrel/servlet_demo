<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="/WEB-INF/hello.tld"%>
<%@ taglib prefix="exx" uri="/WEB-INF/hello2.tld"%>
<%@ taglib prefix="exxx" uri="/WEB-INF/hello3.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tags</title>
</head>
<body>
	<ex:hello/>
	<hr />
	<exx:hello2>
        This is message body
    </exx:hello2>
	<hr />
    <exxx:hello3 message="This is custom tag attribute" />
	<hr />
	<hr />
</body>
</html>
<html><head>
<title>Design report query</title>
<meta name="layout" content="main"/>
</head><body>

<g:if test="${flash.error}">
<div class="errors">${flash.error}</div>
</g:if>
<g:if test="${flash.message}">
<div class="message">${flash.message}</div>
</g:if>

<h1>Design Report Query</h1>

<g:form method="post" action="query">
  <label for="query">Query:</label>
  <input type="text" name="query" value="${query}" size="100" /><br />
  <label for="filename">Filename:</label>
  <input type="text" name="filename" value="${filename}" size="50" /><br />
  <g:actionSubmit value="Test query" action="query" />
  <g:actionSubmit value="Publish" action="publish" /><br />
  <textarea name="output" style="width: 90%; height: 300px; margin: 15px;">${output}</textarea>
</g:form>

</body></html>

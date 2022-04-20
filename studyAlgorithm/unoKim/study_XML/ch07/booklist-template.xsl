<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<body>
				<h2>
					<font color="blue">Our Book's List</font>
				</h2>
				<table border="1" cellspacing="0" width="80%">
					<tr>
						<th>title</th>
						<th>kind</th>
						<th>author</th>
					</tr>
					<xsl:apply-templates select="/booklist/book" />
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="book">
		<xsl:if test="@kind='컴퓨터'">
			<tr>
				<td>
					<xsl:value-of select="title" />
				</td>
				<td>
					<xsl:value-of select="kind" />
				</td>
				<td>
					<xsl:value-of select="author" />
				</td>
			</tr>
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- 시작 템플릿 룰 -->
	<xsl:template match="/">
		<html>
			<body>
				<h2>
					<font color="blue">Our Book's List</font>
					<table border="1" cellspacing="0" width="80%">
						<tr bgcolor="#FFFF66">
							<th>title</th>
							<th>kind</th>
							<th>price</th>
						</tr>
						<xsl:apply-templates select="/booklist/book" />
					</table>
				</h2>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="book">
		<tr>
			<td>
				<xsl:value-of select="title"></xsl:value-of>
				<xsl:value-of select="@kind"></xsl:value-of>
				<xsl:value-of select="price"></xsl:value-of>
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>
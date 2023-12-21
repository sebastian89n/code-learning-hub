<!-- XSLT stylesheet for transforming student data to HTML table -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Student Information</title>
            </head>
            <body>
                <h2>Student Information</h2>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Birthdate</th>
                    </tr>
                    <xsl:apply-templates select="students/student"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="student">
        <tr>
            <td>
                <xsl:value-of select="@id"/>
            </td>
            <td>
                <xsl:value-of select="firstname"/>
            </td>
            <td>
                <xsl:value-of select="lastname"/>
            </td>
            <td>
                <xsl:value-of select="birthdate"/>
            </td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
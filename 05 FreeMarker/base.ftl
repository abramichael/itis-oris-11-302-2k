<#include 'header.ftl'/>

<#macro content></#macro>
<#macro title></#macro>
<#macro page>
    <html>
        <head>
            <link rel="stylesheet" href="/css/styles.css"/>
            <title>
                <@title/>
            </title>
        </head>
        <body>
        <@header/>
        <h1><@title/></h1>
        <@content/>
        </body>
    </html>
</#macro>
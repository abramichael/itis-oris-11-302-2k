<#include "base.ftl"/>

<#macro title>
    Search for username
</#macro>

<#macro content>
    <script type="application/javascript">
        function g() {
			
            $("#found-list").html("");
			
            if ($("#text-input").val().length > 1) {
                $.ajax({
                    url: "/doSearch",
                    data: {
                        "q": $("#text-input").val()
                    },
                    success: function (msg) {
                        let result = $("#found-list");
                        const usernames = JSON.parse(msg);
                        result.append("<h2>Found users:</h2><ul>");
                        usernames.forEach((name) => {
                            result.append("<li>" + name + "</li>");
                        });
                        result.append("</ul>");
                    },
                    error: function (msg) {
                        alert(2);
                    }
                });
            }
        }
    </script>
    <p><input type="text" id="text-input" oninput="g()"/></p>
    <div id="found-list"/>

    <script type="application/javascript"
            src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
    </script>
</#macro>

<@page/>


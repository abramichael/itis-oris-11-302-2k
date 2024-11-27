<#include "base.ftl"/>

<#macro title>
    Feedback
</#macro>

<#macro content>
    <#if liked == 1>
        <p>You like it.</p>
    <#elseif liked == 0>
        <p>You do not like it.</p>
    <#else>
        <form method='POST' action='/like'>
            <select name='liked'>
                <option value='1'>Like</option>
                <option value='0'>Dislike</option>
            </select>
            <input type='submit' value='Send'/>
        </form>
    </#if>
    <form method='POST'>
        <p><textarea name='txt'></textarea></p>
        <p><input type='submit' value='Yes, say it!'/></p>
    </form>
    <#list messages as m>
        <hr/>
        <p><i>Posted on: ${m.getDate()?datetime}</i></p>
        <p><b>${m.getText()}</b></p>
    </#list>
</#macro>

<@page/>
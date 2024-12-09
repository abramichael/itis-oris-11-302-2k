<#include "base.ftl"/>

<#macro title>
    Profile of ${user.username}
</#macro>

<#macro content>
    <#if user?? >
        <form method="post" enctype="multipart/form-data">
            <p><img src="/images?image_name=${user.photoURL}"></p>
            <p><input type="file" name="profile-photo" accept=".jpg"/> </p>
            <p><input type="username" name="username" value="${user.username}"/></p>
            <input type="submit" value="save"/>
        </form>
    </#if>
</#macro>

<@page/>


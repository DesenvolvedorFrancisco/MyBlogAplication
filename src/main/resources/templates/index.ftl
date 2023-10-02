<#-- @ftlvariable name="articles" type="com.example.plugins.Article" -->
<#--@ftlvariable name = " article" type = "kotlin.collections.List<com.example.models.Articles>" -->
<#import "layout.ftl" as layout/>
<@layout.header>
    <#list articles?Reverse as article>
        <div>
            <h3>
                <a href="/articles/${articles.id}">${article.title}</a>
            </h3>
            <p>
                ${article.body}
            </p>
        </div>
    </#list>
    <hr>
    <p>
        <a href="/articles/new">Create article</a>
    </p>
</@layout.header>
<html lang="eng">
<head>
    <title>My blog Aplication </title>
</head>
<body style="text-align: center; font-family: sans-serif">
<img src="francisco.jpg" alt="">
<h1>My blog Aplication</h1>
<p>Feito por Francisco Gonçalves</p>
<hr>
<#list articles?Reverse as article>
    <div>
        <h3>
            <a href="/articles/${articles.id}">${article.title}</a>
        </h3>
        <p>
            ${article.body}
        </p>
    </div>
</#list>
<hr>
<p>
    <a href="/articles/new">Create article</a>
</p>
</body>
</html>






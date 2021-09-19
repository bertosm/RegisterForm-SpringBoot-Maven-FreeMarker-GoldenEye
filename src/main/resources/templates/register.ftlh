<#import "/spring.ftl" as spring />

<!DOCTYPE html>  
<html lang="en">  
    <head>
        <meta charset="UTF-8">
        <title>Goldeneye</title>
        <link href="/css/style.css" rel="stylesheet">
    </head>
    <body>

        <#if user?? && notErrors??>
            <div class="card">
                <h2 class="titlePage"> User Registered </h2>

                
                <div class="flex-container">
                    <div class="show-info-label"> Name: </div> 
                    <div class="show-info-value"> ${user.name} </div>
                </div>

                <div class="flex-container">
                    <div class="show-info-label"> Surname: </div> 
                    <div class="show-info-value"> ${user.surname} </div>
                </div>

                <div class="flex-container">
                    <div class="show-info-label"> Office: </div> 
                    <div class="show-info-value"> ${user.office} </div>
                </div>

                <div class="flex-container">
                    <div class="show-info-label"> Department: </div> 
                    <div class="show-info-value"> ${user.department} </div>
                </div>

                <div class="flex-container">
                    <div class="show-info-label"> email generated: </div> 
                    <div class="show-info-value"> ${user.email} </div>
                </div>
                
                <#if APImsg??>
                        <span class="errormessage"> ${APImsg} </span>
                </#if> 

                <form action="/register" method="get">
                    <input class="btn" type="submit" value="Add other User">
                </form>

            </div>
        <#else>
            <div class="card">
                <h2 class="titlePage"> REGISTER FORM </h2>
                <Form action="/register" method="post">
                    <div class="input_name"> Name: </div>
                    <@spring.formInput "user.name"/> 
                    <div class="errormessage"> <@spring.showErrors ""/> </div>

                    <div class="input_name"> Surname: </div>
                    <@spring.formInput "user.surname"/>
                    <div class="errormessage"> <@spring.showErrors ""/> </div>

                    <div class="flex-container">
                        <div class="input_name"> Office: </div>
                        <select name="office">
                            <#list offices as office>
                                <option value="${office}"> ${office} </option>
                            </#list>
                        </select>

                        <div class="input_name"> Department: </div>
                        <select name="department">
                            <#list departments as department>
                                <option value="${department}"> ${department} </option>
                            </#list>
                        </select>
                    </div> 

                    <#if msg??>
                        <div class="errormessage"> ${msg} </div>
                    </#if> 

                    <div>
                        <input class="btn" type="submit" value="Submit">
                    </div>

                </form>
            </div>
       </#if> 
    </body>
</html>
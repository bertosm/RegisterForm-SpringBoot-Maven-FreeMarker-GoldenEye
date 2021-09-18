<!DOCTYPE html>  
<html lang="en">  
    <head>
        <meta charset="UTF-8">
        <title>Goldeneye</title>
    </head>
    <body>
        <h1> USER REGISTER </h1>
        <#if user??>
            <div> Name: ${user.name} </div>
            <div> Surname: ${user.surname} </div>
            <div> Department: ${user.department} </div>
            <div> Office: ${user.office} </div>
            <div> email: ${user.email} </div>
        
        <#else>
            <h5> ERROR NOT USER REGISTER </h5>
        </#if>
    </body>
</html>
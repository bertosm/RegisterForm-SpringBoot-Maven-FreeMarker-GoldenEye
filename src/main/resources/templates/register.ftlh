<!DOCTYPE html>  
<html lang="en">  
    <head>
        <meta charset="UTF-8">
        <title>Goldeneye</title>
    </head>
    <body>
        <h1>REGISTER FORM</h1>

        <Form action="/register" method="post">
            <div>Name: </div>
            <input type="text" name="name"/> 

            <div> Surname: </div>
            <input type="text" name="surname"/> 

            <div> Department </div>
            <select name="department">
                <option value="Design"> Design </option>
            </select>

            <div> Office </div>
            <select name="office">
                <option value="Milan"> Milan </option>
            </select>

            <div>
                <input type="submit" value="Submit">
                <input type="reset" value="Reset"/>
            </div>

        </form>
    </body>
</html>
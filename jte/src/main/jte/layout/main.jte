@import gg.jte.Content

@param Content content
@param String active

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>JTE</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://unpkg.com/htmx.org@1.9.10"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <h4 class="p-3">JTE</h4>
            <ul class="nav flex-column nav-pills">
                <li class="nav-item"><a class="${active.equals("hello-world") ? "nav-link active" : "nav-link"}" href="/">Hello World</a></li>
                <li class="nav-item"><a class="${active.equals("persons") ? "nav-link active" : "nav-link"}" href="/persons">Persons</a></li>
            </ul>
        </div>

        <div class="col-sm-10 p-2">
            <div>${content}</div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>

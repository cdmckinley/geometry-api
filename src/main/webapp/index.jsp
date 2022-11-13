<html>
<body>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>trihards-homepage</title>
</head>
<h1>Welcome to the TriHards Geometry Service!</h1>

<div id="description">
    <p>This is where the description will go. This is a simple service designed to help
        users solve mathmetic equations for multiple 2D shapes.
    </p>
    <p>Designed by: Austin Mussey, Craig McKinley, Sandhya Sharma</p>
</div>

<div id="guide">
    <h2>User guide</h2>
    <p>This service is designed to solve geometric equations based on the user-entered
        dimensions.
    </p>
    <p>Equations supported:</p>
    <ul>
        <li>Perimeter</li>
        <li>Area</li>
    </ul>
    <p>Shapes supported:</p>
    <ul>
        <li>Circle</li>
        <li>Triangle</li>
        <li>Parallelogram</li>
        <li>Trapezoid</li>
    </ul>

    <p>Here is how to structure requests: </p>
    <ol>
        <li>Add the base URL: /trihards_geometry_api_war/services/2d/</li>
        <li>Enter the shape you want to perform the calculation on</li>
        <li>Enter which calculation you want to run</li>
        <li>Depending on the shape and calculation, enter the length of each side.</li>
    </ol>
</div>

<div id="sample">
    <h2>Sample requests</h2>
    <ul>
        <li>/trihards_geometry_api_war/services/2d/triangle?formula=area&measurements=3&measurements=4</li>
        <li>/trihards_geometry_api_war/services/2d/triangle?formula=perimeter&measurements=5&measurements=4&measurements=5</li>
        <li>/trihards_geometry_api_war/services/2d/circle?formula=area&measurements=4</li>
    </ul>
</div>

</body>
</html>
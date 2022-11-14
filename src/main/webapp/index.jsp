<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css">
    <title>trihards-homepage</title>
</head>
<body>
<h1>Welcome to the TriHards Geometry Service!</h1>

<div id="description">
    <p>This is a simple service designed to help
        users solve mathematical equations for multiple 2D shapes.
    </p>
    <p>Designed by: Austin Mussey, Craig McKinley, Sandhya Sharma</p>
</div>

<div id="guide">
    <h2>Usage</h2>
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
        <li>Enter which calculation you want to run. This can be perimeter or area. The option can be omitted on a
            circle or parallelogram (the program will assume it's a rectangle) to calculate both perimeter and area.</li>
        <li>Depending on the shape and calculation, enter the length of each side.</li>
    </ol>

    <p>Entering measurements:</p>
    <p>Supply measurements such as the radius, sides, and/or height depending on the shape. Measurements can
        either be passed in multiple times containing a measurement each time, or multiple measurements separated
        by commas in passing it once.</p>
    <ul>
        <li>Circle: Perimeter and area require 1 radius</li>
        <li>Triangle: Perimeter requires 3 sides. Area requires 2 measurements: a base side, then the
            height from that side to the opposite corner.</li>
        <li>Parallelogram: Perimeter and Area require two sides that form the same angle for perimeter. Area requires a base side and height, which may be another side on a rectangle.</li>
        <li>Trapezoid: Perimeter requires 4 sides. Area requires 3 measurements: 2 parallel base sides,
            then the height between those sides. Note: The height must come last.</li>
    </ul>
</div>

<div id="sample">
    <h2>Sample requests</h2>
    <ul>
        <li>/services/2d/triangle?formula=area&measurements=3&measurements=4</li>
        <li>/services/2d/triangle?formula=perimeter&measurements=5,4,5</li>
        <li>/services/2d/circle?measurements=4</li>
    </ul>
</div>

</body>
</html>
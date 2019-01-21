<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="b.png" />
    <title>Automobile Maintenance Tracker</title>
</head>
<style>
    /*body {*/
        /*margin: 0;*/
        /*font-family: Arial, Helvetica, sans-serif;*/
    /*}*/

    .hero-image {
        background-image: url("/aa.jpg");
        background-color: #cccccc;
        height: 500px;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        position: relative;
    }

    .hero-text {
        text-align: center;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        color: #33ccff;

    }


    * {
        box-sizing: border-box;
    }

    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th{background-color:#e9e9e9;}
    tr:hover {background-color:#f5f5f5;}


    input[type=text], select, textarea {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        resize: vertical;
    }

    label {
        padding: 12px 12px 12px 0;
        display: inline-block;
    }

    input[type=submit], input[type=reset] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        float: right;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }

    input[type=reset]:hover {
        background-color: #45a049;
    }

    .container {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }

    .col-25 {
        float: left;
        width: 25%;
        margin-top: 6px;
    }

    .col-75 {
        float: left;
        width: 75%;
        margin-top: 6px;
    }

    /* Clear floats after the columns */
    .row:after {
        content: "";
        display: table;
        clear: both;
    }

    #Scartype, #Scartype-u {
        margin-top: 18px;
    }

    #clearButton, #clearButton-u {
        margin-right: 10px;
    }

    /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
    @media screen and (max-width: 600px) {
        .col-25, .col-75, input[type=submit] {
            width: 100%;
            margin-top: 0;
        }
        #Scartype, #Scartype-u {
            margin-top: 0px;
        }
        #clearButton, #clearButton-u {
            width: 100%;
            margin-right: 0px;
            margin-top: 10px;
        }
    }

</style>

<script>
    function load_update_form(id) {
        console.log(id + " Pressed! ");
        var oTable = document.getElementById('mainTable');
        var oCells = oTable.rows.item(id.substr(6)).cells;
        //gets amount of cells of current row
        //var cellLength = oCells.length;
        document.getElementById('imake-u').value = oCells.item(0).innerHTML;
        document.getElementById('imodel-u').value = oCells.item(1).innerHTML;
        if (oCells.item(2).innerHTML === "Electric"){
            document.getElementById('stype-u').getElementsByTagName('option')[1].selected =
                'selected';
        }
        else if (oCells.item(2).innerHTML === "Gas") {
            document.getElementById('stype-u').getElementsByTagName('option')[2].selected =
                'selected';
        }
        else if (oCells.item(2).innerHTML === "Diesel") {
            document.getElementById('stype-u').getElementsByTagName('option')[3].selected =
                'selected';
        }

        document.getElementById('iyear-u').value = oCells.item(3).innerHTML;
        document.getElementById('ilicense-u').value = oCells.item(4).innerHTML;
        document.getElementById('ivin-u').value = oCells.item(5).innerHTML;
        document.getElementById('iodometer-u').value = oCells.item(6).innerHTML;
        document.getElementById('icomment-u').value = oCells.item(7).innerHTML;
        document.getElementById('register_form').style.display = "none";
        document.getElementById('update_form').style.display = "block";
    }

    function update_database(id) {
        $.post("/updateUsers", {mainTable: document.getElementById('mainTable').innerHTML
        , license: document.getElementById('ilicense-u').value
        , odometer: document.getElementById('iodometer-u').value
        , comment: document.getElementById('icomment-u').value}, function(data, status){
            console.log(data);
            // document.getElementById('mainTable').innerHTML = data;
            document.getElementById('register_form').style.display = "block";
            document.getElementById('update_form').style.display = "none";
        })
    }
</script>
<body>

<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:50px">Automobile Maintenance Tracker</h1>
        <h3>Tracking the maintenance of automobiles from a web application</h3>
    </div>
</div>

<%--<h3></h3>--%>

<%--<p>Tracking the maintenance of automobiles from a web application</p>--%>

<div class="container">
    <form action="/registerUsers" id="register_form" method="POST">
        <div class="row">
            <div class="col-25">
                <label for="imake">Make</label>
            </div>
            <div class="col-75">
                <input type="text" id="imake" name="make" placeholder="Name of its company ...">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="imodel">Model</label>
            </div>
            <div class="col-75">
                <input type="text" id="imodel" name="model" placeholder="The model ...">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="stype">Type</label>
            </div>
            <div class="col-75" id="Scartype">
                <select id="stype" name="type">
                    <option selected disabled hidden>Choose Car Type</option>
                    <option value="Electric">Electric</option>
                    <option value="Gas">Gas</option>
                    <option value="Diesel">Diesel</option>
                </select>
            </div>
        </div>
        <%--<div class="row">--%>
            <%--<div class="col-25">--%>
                <%--<label for="modelSelect">Model</label>--%>
            <%--</div>--%>
            <%--<div class="col-75" id="Smodel">--%>
                <%--<select id="modelSelect" name="Model">--%>
                    <%--<option selected disabled hidden>Choose Model</option>--%>
                    <%--<option value="Tesla">Tesla</option>--%>
                    <%--<option value="BMW">BMW</option>--%>
                    <%--<option value="Peugeot">Peugeot</option>--%>
                    <%--<option value="Apple">Apple</option>--%>
                <%--</select>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="row">
            <div class="col-25">
                <label for="iyear">Year</label>
            </div>
            <div class="col-75">
                <input type="text" id="iyear" name="year" placeholder="The year your car has been made ...">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="ilicense">License No.</label>
            </div>
            <div class="col-75">
                <input type="text" id="ilicense" name="license" placeholder="Your license number ...">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="ivin">VIN</label>
            </div>
            <div class="col-75">
                <input type="text" id="ivin" name="vin" placeholder="The VIN number ...">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="iodometer">Odometer</label>
            </div>
            <div class="col-75">
                <input type="text" id="iodometer" name="odometer" placeholder="The first recorded odometer ...">
            </div>
        </div>
        <div class="row" hidden>
            <div class="col-25">
                <label for="icomment">Comment</label>
            </div>
            <div class="col-75">
                <textarea id="icomment" name="maintenance" placeholder="Write the comment ..." style="height:100px"></textarea>
            </div>
        </div>
        <div class="row" style="margin-top: 10px;">
            <input type="submit" value="Register" id="registerButton">
            <input type="reset" value="Clear" id="clearButton">
        </div>
    </form>

    <form action="/updateUsers" id="update_form" style="display: none;" method="POST">
        <div class="row">
            <div class="col-25">
                <label for="imake-u">Make</label>
            </div>
            <div class="col-75">
                <input type="text" id="imake-u" name="make" placeholder="Name of its company ..." readonly="readonly">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="imodel-u">Model</label>
            </div>
            <div class="col-75">
                <input type="text" id="imodel-u" name="model" placeholder="The model ..." readonly="readonly">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="stype-u">Type</label>
            </div>
            <div class="col-75" id="Scartype-u">
                <select id="stype-u" name="type" readonly="readonly">
                    <option selected disabled hidden>Choose Car Type</option>
                    <option value="Electric">Electric</option>
                    <option value="Gas">Gas</option>
                    <option value="Diesel">Diesel</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="iyear-u">Year</label>
            </div>
            <div class="col-75">
                <input type="text" id="iyear-u" name="year" readonly="readonly" placeholder="The year your car has been made ...">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="ilicense-u">License No.</label>
            </div>
            <div class="col-75">
                <input type="text" id="ilicense-u" name="license" readonly="readonly" placeholder="Your license number ...">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="ivin-u">VIN</label>
            </div>
            <div class="col-75">
                <input type="text" id="ivin-u" name="vin" readonly="readonly" placeholder="The VIN number ...">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="iodometer-u">Odometer</label>
            </div>
            <div class="col-75">
                <input type="text" id="iodometer-u" name="odometer" placeholder="The new recorded odometer ..." style="border-color: orangered;">
            </div>
        </div>
        <div class="row" hidden>
            <div class="col-25">
                <label for="icomment-u">Comment</label>
            </div>
            <div class="col-75">
                <textarea id="icomment-u" name="maintenance" placeholder="Write the comment ..." style="height:100px; border-color: orangered;"></textarea>
            </div>
        </div>
        <div class="row" style="margin-top: 10px;">
            <input type="submit" name="submit" value="Update" id="updateButton-u">
            <input type="submit" name="submit" value="Remove" id="clearButton-u" style="background-color: orangered;">
            <input type="submit" name="submit" value="Cancel" id="clearButton-u">
            <%--<input type="reset" value="Clear" id="clearButton-u">--%>
        </div>
    </form>
</div>
<hr>
<div>
    <table id="mainTable">
        <%--will be completed by POST alter--%>
    </table>
</div>

<script>
    function loadUsers() {
        $.post( "/loadUsers", function(data, status){
            document.getElementById('mainTable').innerHTML = data;
        })
            // .done(function() {
            //     alert( "second success" );
            // })
            // .fail(function() {
            //     alert( "error" );
            // })
            // .always(function() {
            //     alert( "finished" );
            // });

        $("#stype-u").css("pointer-events","none");

        document.getElementById('imake').value = "Benz";
        document.getElementById('imodel').value = "SL300";
        document.getElementById('stype').getElementsByTagName('option')[2].selected = 'selected';
        document.getElementById('iyear').value = "2018";
        document.getElementById('ilicense').value = "NE345";
        document.getElementById('ivin').value = "81313532";
        document.getElementById('iodometer').value = "5000";
        document.getElementById('icomment').value = "";
    }
    window.onload = loadUsers;
</script>
</body>
</html>

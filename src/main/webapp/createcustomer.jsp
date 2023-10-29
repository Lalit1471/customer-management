<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Create Customer</title>
    <style>
        .form-container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        .form-container label {
            display: inline-block;
            width: 100px;
        }

        .form-container input[type="text"],
        .form-container input[type="email"],
        .form-container input[type="tel"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .blue-button {
            background-color: blue;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<input type = "hidden" id = "status" value = "<%= request.getAttribute("status") %>">
    <div class="form-container">
        <form action="createcustomer" method="post">
            <label for="firstName">First Name:</label>
            <input type="text" name="firstname" id="firstname" placeholder="First Name"><br>

            <label for="lastName">Last Name:</label>
            <input type="text" name="lastname" id="lastname" placeholder="Last Name"><br>

            <label for="street">Street:</label>
            <input type="text" name="street" id="street" placeholder="Street"><br>

            <label for="address">Address:</label>
            <input type="text" name="address" id="address" placeholder="Address"><br>

            <label for="city">City:</label>
            <input type="text" name="city" id="city" placeholder="City"><br>

            <label for="state">State:</label>
            <input type="text" name="state" id="state" placeholder="State"><br>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" placeholder="Email"><br>

            <label for="phoneNumber">Phone Number:</label>
            <input type="tel" name="phone" id="phonenumber" placeholder="Phone Number"><br>

            <input type="submit" value="Submit" class="blue-button">
        </form>
    </div>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type = "text/javascript">
		var status = document.getElementById("status").value;
		if(status == "success"){
			swal("Account created");
		}
		else swal("Invalid data");
	</script>
</body>
</html>
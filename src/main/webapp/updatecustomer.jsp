<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-group input[type="text"] {
            background-color: #f9f9f9;
        }
        .button-container {
            text-align: center;
        }
        .update-button {
            background-color: #0074a2;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .update-button:hover {
            background-color: #005c8a;
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="updatecustomer" method="post">
            <div class="form-group">
                <label for="name">First Name:</label>
                <input type="text" id="name" name="firstname" placeholder="Enter your name" required>
            </div>
            <div class="form-group">
                <label for="email">New Email:</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="form-group">
                <label for="city">New City:</label>
                <input type="text" id="city" name="city" placeholder="Enter your city" required>
            </div>
            <div class="form-group">
                <label for="street">New Street:</label>
                <input type="text" id="street" name="street" placeholder="Enter your street" required>
            </div>
            <div class="form-group">
                <label for="state">New State:</label>
                <input type="text" id="state" name="state" placeholder="Enter your state" required>
            </div>
            <div class="form-group">
                <label for="address">New Address:</label>
                <input type="text" id="address" name="address" placeholder="Enter your address" required>
            </div>
            <div class="form-group">
                <label for="phone">New Phone:</label>
                <input type="tel" id="phone" name="phone" placeholder="Enter your phone" required>
            </div>
            <div class="button-container">
                <button type="submit" class="update-button">Update</button>
            </div>
        </form>
    </div>
</body>
</html>

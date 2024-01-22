<?php
// Retrieve the form data
$name = $_POST['name'];
$email = $_POST['email'];
$apartment = $_POST['apartment'];
$amount = $_POST['amount'];
$card_type = $_POST['pay'];

// Create a database connection (replace with your database credentials)
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "society";

$conn = new mysqli($servername, $username, $password, $dbname);

// Check for connection errors
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Insert the payment details into the database
$sql = "INSERT INTO payments (name, email, apartment, amount,card_type) VALUES ('$name', '$email', '$apartment', '$amount','$card_type')";

if ($conn->query($sql) === TRUE) {
    echo "Payment successful!";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

// Close the database connection
$conn->close();
?>
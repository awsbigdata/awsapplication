<html>
<head>
 <title>API Requester</title>
<style>
.center {
  width: 300px;
  height: 300px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
</style>
</head>
<body>
<div class="center">
<form action="/api" method="post">
  <label for="apiname">API Name:</label>
  <input type="text" id="name" name="name"><br><br>
  <input type="submit" value="Submit">
</form>
</div>
</body>
</html>
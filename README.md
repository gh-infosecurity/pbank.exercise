mvn clean install exec:exec

http://127.0.0.1:8080/

InputData:

&lt;InputData&gt;<br/>   &lt;values length=&quot;5&quot;&gt;123, 1q, 2, 3g, 5, 5, 5,5&lt;/values&gt;<br/>&lt;/InputData&gt;

Choose Operation at
http://127.0.0.1:8080/change

POST http://127.0.0.1:8080/input


<form method="post" action="file-upload-1.htm" name="submit" enctype="multipart/form-data">
  <input type="file" name="fileField"><br /><br />
  <input type="submit" name="submit" value="Submit">
</form>

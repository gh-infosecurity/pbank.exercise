mvn clean install exec:exec

http://127.0.0.1:8080/

InputData:

&lt;InputData&gt;<br/>   &lt;values length=&quot;5&quot;&gt;123, 1q, 2, 3g, 5, 5, 5,5&lt;/values&gt;<br/>&lt;/InputData&gt;

Choose Operation at
http://127.0.0.1:8080/change

POST http://127.0.0.1:8080/input


&lt;form method=&quot;post&quot; action=&quot;file-upload-1.htm&quot; name=&quot;submit&quot; enctype=&quot;multipart/form-data&quot;&gt;<br/>  &lt;input type=&quot;file&quot; name=&quot;fileField&quot;&gt;&lt;br /&gt;&lt;br /&gt;<br/>  &lt;input type=&quot;submit&quot; name=&quot;submit&quot; value=&quot;Submit&quot;&gt;<br/>&lt;/form&gt;

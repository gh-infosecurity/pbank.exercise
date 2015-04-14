mvn clean install exec:exec

http://127.0.0.1:8080/

InputData:
<InputData>
   <values length="5">123, 1q, 2, 3g, 5, 123, 2, 3g</values>
</InputData>


POST http://127.0.0.1:8080/filter
POST http://127.0.0.1:8080/reverse
POST http://127.0.0.1:8080/input

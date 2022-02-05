package dev.naman.splitwise_feb22.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {
    public ResponseStatusCode statusCode;
    public T data;
}


// ArrayList<Animal>
// HashMap<Animal, Long>

// class HashMap<T, X> {
//   private List<T> keys;
//   private List<X> values;
// }
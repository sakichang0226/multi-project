package com.example.multi_api.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class TodoRequest {

    @NonNull
    Long userId;

}

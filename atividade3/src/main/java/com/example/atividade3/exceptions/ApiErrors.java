package com.example.atividade3.exceptions;

import java.util.*;
import lombok.Getter;
public class ApiErrors {
@Getter
private List<String> errors;
public ApiErrors(String mensagemErro) {
errors = Arrays.asList(mensagemErro);
}}

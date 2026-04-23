package com.assignment.Week7.beans;

import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

@Data
public class AddReviewsRequestBean {
    Long courseId;
    Long instructorId;
}

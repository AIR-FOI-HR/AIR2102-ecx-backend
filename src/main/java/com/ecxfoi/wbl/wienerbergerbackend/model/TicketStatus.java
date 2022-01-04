package com.ecxfoi.wbl.wienerbergerbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum TicketStatus
{
    New, InProgress, Resolved
}
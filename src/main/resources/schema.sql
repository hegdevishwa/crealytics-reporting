create table report
(
    site        varchar(25) not null,
    requests    int         not null,
    impressions int         not null,
    clicks      int         not null,
    conversions int         not null,
    revenue     double      not null,
    CTR         double,
    CR          double,
    fill_rate   double,
    eCPM        double,
    month       varchar(25)
);
# ksqlDB UDF/UDAF

This repository has the list of custom ksqlDB UDF/UDAF created by Entechlog.com to solve various real-life use cases.
---

Table of Contents

* <a href="#Requirements">Versions and Requirements</a>
* <a href="#ksqlDB UDF's">ksqlDB UDF's</a>
* <a href="#License">License</a>

---

<a name="Requirements"></a>

# Versions and Requirements

Compatible [KSQL](https://github.com/confluentinc/ksql) versions:

* The examples in this repository are built against KSQL 5.4.0 for Apache Kafka and Confluent Platform 5.4.0.

Requirements to locally build, test, package the UDF/UDAF examples:

* Java 8+
* Maven 3.6+

See my blog on how to create UDF's at [Entechlog](https://www.entechlog.com/2020/02/how-to-create-and-validate-ksqldb-udfs.html) for more details

<a name="ksqlDB UDF's"></a>

# ksqlDB UDF's

| Usage                                    | Type      | Description                                                   | Demo URL |
| ---------------------------------------- | --------- | --------------------------------------------------------------|----------|
| UDF_TOTITLECASE(col1)                    | UDF       | Return capitalized version of first character in each word    | [Demo](https://asciinema.org/a/8lXP671qZk85XGNbCYZyOsHDh) |
| UDF_EXTRACTNAME(col1,'lastName')         | UDF       | Returns firstName, middleName, lastName, suffix from fullName | [Demo](https://asciinema.org/a/5qhuIBWLQahEsl3WBexFIfcnX) |

To package the UDFs/UDAFs ([details](https://docs.confluent.io/current/ksql/docs/developer-guide/implement-a-udf.html#build-the-udf-package)):

To deploy the packaged UDFs/UDAFs to KSQL servers, refer to the
[KSQL documentation on UDF/UDAF](https://docs.confluent.io/current/ksql/docs/developer-guide/udf.html#deploying).
You can verify that the UDFs/UDAFs are available for use by running `SHOW FUNCTIONS`, and show the details of
any specific function with `DESCRIBE FUNCTION <name>`.

To use the UDFs/UDAFs in KSQL

## UDF_TOTITLECASE

```sql

SELECT C1, UDF_TOTITLECASE(C1) FROM T1;
```

## UDF_EXTRACTNAME

```sql

SELECT C1, UDF_TOTITLECASE(C1,'firstName'), UDF_TOTITLECASE(C1,'lastName') FROM T1;
```

<a name="License"></a>

# License

See [LICENSE](LICENSE) for licensing information.

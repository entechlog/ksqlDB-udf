# ksqlDB UDF/UDAF

This repository has the list of custom ksqlDB UDF/UDAF created by Entechlog.com to solve various real-life use cases.
---

Table of Contents

* <a href="#Requirements">Versions and Requirements</a>
* <a href="#UDF Index">UDF Index</a>
* <a href="#License">License</a>

---

<a name="Requirements"></a>

# Versions and Requirements

Compatible [KSQL](https://github.com/confluentinc/ksql) versions:

* The examples in this repository are built against KSQL 5.4.0 for Apache Kafka and Confluent Platform 5.4.0.

Requirements to locally build, test, package the UDF/UDAF examples:

* Java 8+
* Maven 3.6+

See my blog on this at [Entechlog](https://entechlog.com) for more details

<a name="UDF Index"></a>

# Examples

| Usage                                    | Type      | Description                                                |
| ---------------------------------------- | --------- | -----------------------------------------------------------|
| UDF_TOTITLECASE(col1)                    | UDF       | Return capitalized version of first character in each word |

To package the UDFs/UDAFs ([details](https://docs.confluent.io/current/ksql/docs/developer-guide/implement-a-udf.html#build-the-udf-package)):

To deploy the packaged UDFs/UDAFs to KSQL servers, refer to the
[KSQL documentation on UDF/UDAF](https://docs.confluent.io/current/ksql/docs/developer-guide/udf.html#deploying).
You can verify that the UDFs/UDAFs are available for use by running `SHOW FUNCTIONS`, and show the details of
any specific function with `DESCRIBE FUNCTION <name>`.

To use the UDFs/UDAFs in KSQL

## UDF_TOTITLECASE

```sql

SELECT UDF_TOTITLECASE(C1) FROM TABLE;
```

<a name="License"></a>

# License

See [LICENSE](LICENSE) for licensing information.

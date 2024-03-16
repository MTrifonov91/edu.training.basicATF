Feature: Validate resources via API

  Scenario: Validate resources against input JSON via API with Response = 200
    Given Specifications are installed with expected response code 200
    When A GET request is sent to endpoint: GET_RESOURCES
    Then Response matches data from the following JSON file: 'src/test/resources/input-data/ResourcesResponse.json'

  Scenario: Validate resources against given object data via API with Response = 200
    Given Specifications are installed with expected response code 200
    When A GET request is sent to endpoint: GET_RESOURCES
    Then Response for object 'Data' matches the following data:

      | id | name           | year | color   | pantone_value |
      | 1  | cerulean       | 2000 | #98B2D1 | 15-4020       |
      | 2  | fuchsia rose   | 2001 | #C74375 | 17-2031       |
      | 3  | true red       | 2002 | #BF1932 | 19-1664       |
      | 4  | aqua sky       | 2003 | #7BC4C4 | 14-4811       |
      | 5  | tigerlily      | 2004 | #E2583E | 17-1456       |
      | 6  | blue turquoise | 2005 | #53B0AE | 15-5217       |

  @Res
  Scenario: Validate resources against provided via API data with Response = 200
    Given Specifications are installed with expected response code 200
    When A GET request is sent to endpoint: GET_RESOURCES
    Then Response matches the following dataaaa:

      | page        | 1                                  |                                                                          |      |         |         |
      | per_page    | 6                                  |                                                                          |      |         |         |
      | total       | 12                                 |                                                                          |      |         |         |
      | total_pages | 2                                  |                                                                          |      |         |         |
      | data        | 1                                  | cerulean                                                                 | 2000 | #98B2D1 | 15-4020 |
      | data        | 2                                  | fuchsia rose                                                             | 2001 | #C74375 | 17-2031 |
      | data        | 3                                  | true red                                                                 | 2002 | #BF1932 | 19-1664 |
      | data        | 4                                  | aqua sky                                                                 | 2003 | #7BC4C4 | 14-4811 |
      | data        | 5                                  | tigerlily                                                                | 2004 | #E2583E | 17-1456 |
      | data        | 6                                  | blue turquoise                                                           | 2005 | #53B0AE | 15-5217 |
      | support     | https://reqres.in/#support-heading | To keep ReqRes free, contributions towards server costs are appreciated! |      |         |         |


#    Then Response matches the following data:
#
#      | id | name           | year | color   | pantone_value |
#      | 1  | cerulean       | 2000 | #98B2D1 | 15-4020       |
#      | 2  | fuchsia rose   | 2001 | #C74375 | 17-2031       |
#      | 3  | true red       | 2002 | #BF1932 | 19-1664       |
#      | 4  | aqua sky       | 2003 | #7BC4C4 | 14-4811       |
#      | 5  | tigerlily      | 2004 | #E2583E | 17-1456       |
#      | 6  | blue turquoise | 2005 | #53B0AE | 15-5217       |

#    Then Response matches the followingg:
#
#      | page          | 1                                                                        |
#      | per_page      | 6                                                                        |
#      | total         | 12                                                                       |
#      | total_pages   | 2                                                                        |
#      | id            | 1                                                                        |
#      | name          | cerulean                                                                 |
#      | year          | 2000                                                                     |
#      | color         | #98B2D1                                                                  |
#      | pantone_value | 15-4020                                                                  |
#      | url           | https://reqres.in/#support-heading                                       |
#      | text          | To keep ReqRes free, contributions towards server costs are appreciated! |


#      | id | name           | year | color   | pantone_value |
#      | 1  | cerulean       | 2000 | #98B2D1 | 15-4020       |
#      | 2  | fuchsia rose   | 2001 | #C74375 | 17-2031       |
#      | 3  | true red       | 2002 | #BF1932 | 19-1664       |
#      | 4  | aqua sky       | 2003 | #7BC4C4 | 14-4811       |
#      | 5  | tigerlily      | 2004 | #E2583E | 17-1456       |
#      | 6  | blue turquoise | 2005 | #53B0AE | 15-5217       |





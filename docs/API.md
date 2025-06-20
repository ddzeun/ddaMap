| 기능 ID | 기능명 | API | 비고 |
| --- | --- | --- | --- |
| **F-01** | 대여소 목록 보기 | `GET /api/v1/stations` | 지도 중심 좌표 기준으로 대여소 목록 반환 |
| **F-02** | 지도 탐색 | `GET /api/v1/stations` | 중심 좌표 변경 시 같은 API로 요청 |
| **F-03** | 대여소 정보 새로고침 | `GET /api/v1/stations` | 같은 API, 단 갱신시간 표시만 다름 |
| **F-04** | 현재 위치로 이동 | ❌ API 없음 | 클라이언트에서 위치 재요청만 수행 |
| **F-05** | 대여소 상세 정보 | `GET /api/v1/stations/{id}` | 마커 클릭 시 해당 대여소 상세 조회 |
| **F-06** | 대여소 검색 | `GET /api/v1/stations?keyword={keyword}` | 키워드 기반 대여소 검색 |
| **F-07** | 경로 탐색 | `POST /api/v1/routes` | 출발지, 도착지, 경로 타입 등을 포함한 경로 요청 |

---

## F-01~03. 대여소 목록 조회 (지도 중심 기반)

> GET /api/v1/stations
>

| 항목 | 내용 |
| --- | --- |
| **설명** | 현재 지도 중심 좌표를 기준으로 반경 내 대여소 목록을 조회한다.지도 이동/새로고침 모두 동일 API 사용 |
| **Method** | `GET` |
| **Query Params** | `lat` (Float, 필수): 지도 중심 위도`lng` (Float, 필수): 지도 중심 경도`radius` (Integer, 선택): 조회 반경(m) (기본: 1000m) |
| **Response** | 200 OK |
| **응답 JSON 예시** |  |

```json
[
  {
    "id": 101,
    "name": "광화문역 1번 출구 앞",
    "lat": 37.5701,
    "lng": 126.9768,
    "remain_bikes": 4,
    "total_docks": 10
  }
]

```

| **상황** | **상태 코드** | **에러 코드 (예시)** | **응답 메시지 (예시)** |
| --- | --- | --- | --- |
| 필수 파라미터 누락 | 400 | `INVALID_PARAMETER` | 필수 파라미터 'lat' 또는 'lng'가 누락되었습니다. |
| 파라미터 형식 오류 | 400 | `INVALID_PARAMETER` | 'lat'는 -90 ~ 90 사이의 숫자여야 합니다. |
| 외부 API(서울시) 오류 | 503 | `SERVICE_UNAVAILABLE` | 외부 데이터 서버가 응답하지 않습니다. 잠시 후 다시 시도해주세요. |
| 우리 서버 내부 오류 | 500 | `INTERNAL_SERVER_ERROR` | 서버 내부에 알 수 없는 오류가 발생했습니다. |

---

## 📌 F-04. 현재 위치로 이동

> 클라이언트 로직 (API 없음)
>

| 항목 | 내용 |
| --- | --- |
| **설명** | 클라이언트가 GPS를 이용해 사용자의 현재 위치를 탐색하고, 해당 위치로 지도를 이동시킴 |
| **API 사용 여부** | ❌ 없음 |
| **예외** | GPS 비허용 또는 위치 인식 불가 시 사용자에게 알림 표시 |

---

## 📌 F-05. 대여소 상세 정보 조회

> GET /api/v1/stations/{id}
>

| 항목 | 내용 |
| --- | --- |
| **설명** | 대여소의 상세 정보를 조회 (마커 선택 또는 검색 후 진입) |
| **Method** | `GET` |
| **Path Variable** | `id` (Long, 필수): 대여소 ID |
| **Response** | 200 OK |
| **응답 JSON 예시** |  |

```json
{
  "id": 101,
  "name": "광화문역 1번 출구 앞",
  "lat": 37.5701,
  "lng": 126.9768,
  "remain_bikes": 4,
  "total_docks": 10,
  "address": "서울특별시 종로구 세종대로"
}

```

| **상황** | **상태 코드** | **에러 코드 (예시)** | **응답 메시지 (예시)** |
| --- | --- | --- | --- |
| ID가 숫자가 아닐 때 | 400 | `INVALID_PARAMETER` | 대여소 ID는 숫자 형식이어야 합니다. |
| 존재하지 않는 ID | 404 | `STATION_NOT_FOUND` | 해당 ID의 대여소를 찾을 수 없습니다. |

---

## 📌 F-06. 대여소 검색

> GET /stations/search?keyword=
>

| 항목 | 내용 |
| --- | --- |
| **설명** | 대여소명 또는 대여소번호로 검색 |
| **Method** | `GET` |
| **Query Params** | `keyword` (String, 필수): 검색 키워드 |
| **Response** | 200 OK |
| **응답 JSON 예시** |  |

```json
[
  {
    "id": 102,
    "name": "서울역 3번 출구",
    "lat": 37.5547,
    "lng": 126.9706,
    "remain_bikes": 2,
    "total_docks": 15
  }
]

```

| 상황 | 상태 코드 | 에러 코드 (예시) |
| --- | --- | --- |
| keyword 파라미터 없음 | 400 | INVALID_PARAMETER |
| 검색어가 너무 짧을 때 | 400 | KEYWORD_TOO_SHORT |
| 결과 없음 | 200 | - |

---

## 📌 F-07. 대여소 상세 정보 조회

> POST /api/v1/routes
>

| 항목 | 내용 |
| --- | --- |
| **설명** | 출발지, 도착지, 경로 타입 등을 포함한 경로 탐색 |
| **Method** | `POST` |
| **Path Variable** | 하단의 JSON |
| **Response** | 200 OK |

**Request Body**

```json
{
		"origin": {
				"name": "출발지 주소 또는 이름",
				"lat": 37.5701,
				"lng": 126.9768
		},
		"destination": {
				"name": "도착지 주소 또는 이름",
				"lat": 37.5547,
				"lng": 126.9706
		},
		"type": "DDA" // DDA, WALK, BIKE
}
```

**Response**

```json
{
  "total_duration": 1800, // 총 소요시간 (초 단위)
  "path": [ // 전체 경로를 구성하는 세부 경로들
    {
      "type": "WALK",
      "duration": 300,
      "distance": 400, // 미터 단위
      "start_station": null,
      "end_station": {
        "id": 101,
        "name": "광화문역 1번 출구 앞"
      }
    },
    {
      "type": "BIKE",
      "duration": 1200,
      "distance": 3000,
      "start_station": {
        "id": 101,
        "name": "광화문역 1번 출구 앞"
      },
      "end_station": {
        "id": 102,
        "name": "서울역 3번 출구"
      }
    },
    {
      "type": "WALK",
      "duration": 300,
      "distance": 400,
      "start_station": {
        "id": 102,
        "name": "서울역 3번 출구"
      },
      "end_station": null
    }
  ],
  "route_geometry": "encoded_polyline_string_from_Maps" // 지도에 경로를 그리기 위한 암호화된 좌표 문자열
}
```

| **상황** | **상태 코드** | **에러 코드 (예시)** | **응답 메시지 (예시)** |
| --- | --- | --- | --- |
| 요청 Body의 JSON 깨짐 | 400 | `MALFORMED_JSON` | 요청 형식이 올바르지 않습니다. |
| 필수 값 누락 (origin 등) | 400 | `INVALID_PARAMETER` | 필수 값 'origin' 정보가 누락되었습니다. |
| 출발지 근처 이용 가능 자전거 없음 | 404 | `NO_BIKES_AVAILABLE` | 출발지 근처에 이용 가능한 자전거가 없습니다. |
| 경로 탐색 실패 (경로가 없는 지역) | 404 | `ROUTE_NOT_FOUND` | 출발지와 목적지 사이의 경로를 찾을 수 없습니다. |
| 외부 API(Google Maps) 오류 | 503 | `SERVICE_UNAVAILABLE` | 경로 탐색 서비스가 응답하지 않습니다. 잠시 후 다시 시도해주세요. |
| 우리 서버 내부 오류 | 500 | `INTERNAL_SERVER_ERROR` | 경로 탐색 중 알 수 없는 오류가 발생했습니다. |

에러 JSON 예시

JSON

`{
  "timestamp": "2025-06-19T14:10:30.123Z",
  "status": 400,
  "error": "INVALID_PARAMETER",
  "message": "필수 파라미터 'lat'가 누락되었습니다."
}`

- `timestamp`: 에러 발생 시간
- `status`: HTTP 상태 코드
- `error`: 서버에서 관리하는 고유한 에러 코드 (클라이언트가 이 코드를 보고 특정 분기 처리를 할 수 있어)
- `message`: 개발자나 사용자가 읽을 수 있는 친절한 설명
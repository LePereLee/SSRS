package com.example.spring_seatreservation.controller;

// 引入必要的类和注解
// ...

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DynamicTaskService dynamicTask;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private PublicMapper publicMapper;

    // 测试 addReservation 方法
    @Test
    void testAddReservation() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("startTime", 1625014901000L);
        requestMap.put("endTime", 1625015601000L);
        requestMap.put("sid", "seat1");
        requestMap.put("rid", 1);
        requestMap.put("uid", "user1");

        List<Map<String, Object>> curReservation = Collections.emptyList(); // 模拟数据
        given(userMapper.getCurReservation(eq("user1"))).willReturn(curReservation);

        mockMvc.perform(post("/user/addReservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"));
    }

    // 测试 toSigned 方法
    @Test
    void testToSigned() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("rid", 1);
        requestMap.put("number", 123456);

        Map<String, Object> reservation = new HashMap<>();
        reservation.put("state", "TIME_BEGAN");
        reservation.put("startTime", 1625014901000L);
        reservation.put("rid", 1);
        reservation.put("sid", "seat1");
        given(userMapper.getReservationByRid(eq(1))).willReturn(reservation);

        mockMvc.perform(post("/user/toSigned")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.verify").value(true));
    }

    // 测试 toLeave 方法
    @Test
    void testToLeave() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("rid", 1);
        requestMap.put("sid", "seat1");

        mockMvc.perform(post("/user/toLeave")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk());
    }

    // 测试 getReservationNeedSub 方法
    @Test
    void testGetReservationNeedSub() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("uid", "user1");

        List<Map<String, Object>> reservations = Collections.singletonList(new HashMap<>()); // 模拟数据
        given(userMapper.getReservation(eq(requestMap))).willReturn(reservations);

        mockMvc.perform(post("/user/getReservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"));
    }

    // 测试 getReservationByUid 方法
    @Test
    void testGetReservationByUid() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("uid", "user1");

        List<Map<String, Object> reservations = Collections.singletonList(new HashMap<>()); // 模拟数据
        given(userMapper.getReservationByUid(eq("user1"))).willReturn(reservations);

        mockMvc.perform(post("/user/getReservationByUid")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rows").isArray())
                .andExpect(jsonPath("$.rows").isNotEmpty());
    }

    // 测试 getScore 方法
    @Test
    void testGetScore() throws Exception {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("uid", "user1");

        given(userMapper.getScore(eq("user1"))).willReturn(88.0);

        mockMvc.perform(post("/user/getScore")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestMap)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.score").value(88.0));
    }

    // 根据实际方法实现，为其他方法编写相应的测试用例...
}
package com.example.hotelmonitoring.constant;

public abstract class SQLCommand {
    public static String VIEW_BOOKED_ROOMS = "SELECT R.Room_Num, RT.Room_Desc\n" +
            "FROM Room AS R\n" +
            "JOIN Reservation AS Res ON R.Room_ID = Res.Room_ID\n" +
            "JOIN Room_Type AS RT ON R.Room_Type_Code = RT.Room_Type_Code\n" +
            "WHERE '2023-05-04' BETWEEN Res.Check_In_Date AND Res.Check_Out_Date;";
    public static String VIEW_AVAILABLE_ROOMS = "SELECT R.Room_Num, RT.Room_Desc\n" +
            "FROM Room AS R\n" +
            "JOIN Room_Type AS RT ON R.Room_Type_Code = RT.Room_Type_Code\n" +
            "WHERE R.Room_ID NOT IN (\n" +
            "  SELECT Room_ID\n" +
            "  FROM Reservation\n" +
            "  WHERE '2023-05-04' BETWEEN Check_In_Date AND Check_Out_Date\n" +
            ");";
    public static String View_ACTIVE_GUESTS = "SELECT G.Guest_Full_Name, Res.Check_In_Date, Res.Check_Out_Date, R.Room_Num\n" +
            "FROM Guest AS G\n" +
            "JOIN Reservation AS Res ON G.Guest_ID = Res.Guest_ID\n" +
            "JOIN Room AS R ON Res.Room_ID = R.Room_ID;";
    public static String VIEW_FUTURE_AVAILABLE_ROOMS = "SELECT R.Room_Num, RT.Room_Desc\n" +
            "FROM Room AS R\n" +
            "JOIN Room_Type AS RT ON R.Room_Type_Code = RT.Room_Type_Code\n" +
            "WHERE R.Room_ID NOT IN (\n" +
            "  SELECT Room_ID\n" +
            "  FROM Reservation\n" +
            "  WHERE '2023-05-10' BETWEEN Check_In_Date AND Check_Out_Date\n" +
            ");";
    public static String VIEW_ROOM_INVOICE = "SELECT I.Invoice_ID, I.Room_Charge, I.Extra_Charges, I.Payment_Type\n" +
            "FROM Invoice AS I\n" +
            "JOIN Reservation AS Res ON I.Reservation_ID = Res.Reservation_ID\n" +
            "JOIN Room AS R ON Res.Room_ID = R.Room_ID\n" +
            "WHERE R.Room_Num = 101;";
    public static String VIEW_MONTHLY_REVENUE = "SELECT SUM(I.Room_Charge + I.Extra_Charges) AS TotalRevenue\n" +
            "FROM Invoice AS I\n" +
            "JOIN Reservation AS Res ON I.Reservation_ID = Res.Reservation_ID\n" +
            "WHERE Res.Check_Out_Date >= '2023-05-01' AND Res.Check_Out_Date <= '2023-05-31';";
    public static String VIEW_GUEST_RESERVATIONS = "SELECT Res.Check_In_Date, I.Room_Charge + I.Extra_Charges AS TotalCharges\n" +
            "FROM Reservation AS Res\n" +
            "JOIN Invoice AS I ON Res.Reservation_ID = I.Reservation_ID\n" +
            "WHERE Res.Guest_ID = 'G001';";
    public static String VIEW_CASH_PAYMENTS_FOR_INTERVAL = "SELECT P.Payment_ID, PT.Payment_Desc, I.Room_Charge, I.Extra_Charges, I.Payment_Type, P.Invoice_ID\n" +
            "FROM Payment AS P\n" +
            "JOIN Payment_Type AS PT ON P.Payment_Type = PT.Payment_Code\n" +
            "JOIN Invoice AS I ON P.Invoice_ID = I.Invoice_ID\n" +
            "JOIN Reservation AS Res ON I.Reservation_ID = Res.Reservation_ID\n" +
            "WHERE PT.Payment_Desc = 'cash' AND Res.Check_Out_Date >= '2023-04-01' AND Res.Check_Out_Date <= '2023-05-01';";
    public static String VIEW_UPCOMING_RESERVATION_FOR_ROOM = "SELECT Res.Reservation_ID, G.Guest_Full_Name, Res.Check_In_Date, Res.Check_Out_Date\n" +
            "FROM Reservation AS Res\n" +
            "JOIN Room AS R ON Res.Room_ID = R.Room_ID\n" +
            "JOIN Guest AS G ON Res.Guest_ID = G.Guest_ID\n" +
            "WHERE R.Room_Num = 101 AND Res.Check_In_Date > '2023-04-24';";

    public static String VIEW_EXTRA_CHARGE_REVENUE = "SELECT I.Extra_Charges, SUM(I.Extra_Charges)\n" +
            "FROM Invoice AS I\n" +
            "JOIN Reservation AS Res ON I.Reservation_ID = Res.Reservation_ID\n" +
            "WHERE Res.Check_Out_Date >= '2023-04-01' AND Res.Check_Out_Date <= '2023-05-01'\n" +
            "GROUP BY I.Extra_Charges;";

    public static String VIEW_ROOMS_RESERVED = "SELECT R.Room_Num, COUNT(Res.Reservation_ID)\n" +
            "FROM Room AS R\n" +
            "JOIN Reservation AS Res ON R.Room_ID = Res.Room_ID\n" +
            "GROUP BY R.Room_ID\n" +
            "ORDER BY COUNT(Res.Reservation_ID) DESC;";
    public static String VIEW_ROOM_TYPES_RESERVED = "SELECT RT.Room_Desc, COUNT(Res.Reservation_ID)\n" +
            "FROM Room_Type AS RT\n" +
            "JOIN Room AS R ON RT.Room_Type_Code = R.Room_Type_Code\n" +
            "JOIN Reservation AS Res ON R.Room_ID = Res.Room_ID\n" +
            "GROUP BY RT.Room_Type_Code\n" +
            "ORDER BY COUNT(Res.Reservation_ID) DESC;";
    public static String VIEW_REVENUE_ROOM_TYPE = "SELECT RT.Room_Desc, SUM(I.Room_Charge + I.Extra_Charges) AS TotalRevenue\n" +
            "FROM Room_Type AS RT\n" +
            "JOIN Room AS R ON RT.Room_Type_Code = R.Room_Type_Code\n" +
            "JOIN Reservation AS Res ON R.Room_ID = Res.Room_ID\n" +
            "JOIN Invoice AS I ON Res.Reservation_ID = I.Reservation_ID\n" +
            "GROUP BY RT.Room_Type_Code\n" +
            "ORDER BY TotalRevenue DESC;";
    public static String VIEW_ALL_ROOM_TYPES = "SELECT Room_Type_Code, Room_Desc, Room_Cost\n" +
            "FROM Room_Type;";
    public static String VIEW_ALL_EMPLOYESS = "SELECT ER.Role_Title, E.Emp_Full_Name\n" +
            "FROM Emp_Role AS ER\n" +
            "JOIN Employee AS E ON ER.Role_Code = E.Role_Code\n" +
            "ORDER BY ER.Role_Title;";


}

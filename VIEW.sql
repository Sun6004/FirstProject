CREATE OR REPLACE VIEW V_RESERVATION
  AS 
   SELECT
        E.RNO,
        E.RDATE,
        E.MEM_NAME,
        F.DSI_NAME,
        G.MENU_NAME,
        H.PRICE
   FROM (SELECT
        C.RNO AS RNO,
        C.RDATE AS RDATE,
        D.MEM_NAME AS MEM_NAME,
        C.DSI_NO AS DSI_NO,
        C.MENU_NO AS MENU_NO
    FROM(select
        a.R_NO as RNO,
        a.R_DATE AS RDATE,
        a.MEM_ID AS MEM_ID,
        b.DSI_NO AS DSI_NO,
        b.MENU_NO AS MENU_NO
    from RESERVATION a,RESERVATION_DETAIL b
    where a.R_NO=b.R_NO)C, MEMBER D
    WHERE C.MEM_ID = D.MEM_ID)E, DESIGNER F, MENU G, MENU_PRICE H
    WHERE E.DSI_NO = F.DSI_NO
    AND E.MENU_NO = G.MENU_NO
    AND E.MENU_NO = H.MENU_NO
    AND G.MENU_NO = H.MENU_NO
    AND F.DSI_NO = H.DSI_NO
   WITH READ ONLY;
   

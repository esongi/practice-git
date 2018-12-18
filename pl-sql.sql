--PL-SQL
--PL/SQL �� Oracle's Procedural Language extension to SQL. �� ���� �Դϴ�. 
--SQL���忡�� ��������, ����ó��(IF), �ݺ�ó��(LOOP, WHILE, FOR)���� �����ϸ�, 
--����Ŭ ��ü�� ����Ǿ� �ִ�Procedure Language�Դϴ�
--DECLARE���� �̿��Ͽ� ���ǵǸ�, ������ ����� ���� �����Դϴ�. 
--PL/SQL ���� ���� ������ �Ǿ� �ְ�PL/SQL �ڽ��� ������ ������ ������ �ֽ��ϴ�.

--Tool > ���� > DBMS ���â > + ��ư Ŭ�� > ����� ����(������)
--DBMS ���â : ��Ŭ���� console â

--pl-sql (java : System.out.println()) ��� Ȯ��
--DBMS ��� â����

--1.pl-sql ���� ���� ����
BEGIN
  DBMS_OUTPUT.PUT_LINE('HELLO WORLD');
END;

--pl-sql
--�����(����) 
--�����(���� ���� �Ҵ� , �����)
--���ܺ�(Exception)

DECLARE --����
  vno number(4);
  vname varchar2(20);
BEGIN
  vno := 100; -- �Ҵ� >  String s; s = "ȫ�浿"
  vname := 'kglim';
  DBMS_OUTPUT.PUT_LINE(vno); --ȭ�� ���
  DBMS_OUTPUT.PUT_LINE(vname || '�Դϴ�');
END;

--���� ���� ��� (Ÿ��)
--DECLARE
--v_job varchar2(10);
--v_count number := 10; --�ʱⰪ ����
--v_date date := sysdate + 7; --�ʱⰪ ����
--v_valid boolean not null := true
--------------------------------------------------------------------------------
DECLARE
  vno number(4);
  vname varchar2(20);
BEGIN
   select empno ,ename
      into vno , vname --pl-sql ����ϴ� ���� (into) . ������ ������ ���
   from emp
   where empno=&empno; --& �ڹ� scanner  ��Ȱ (�Է°� �ޱ�)
   
   DBMS_OUTPUT.PUT_LINE('������ : ' || vno || '/' || vname);
END;
 
--�ǽ� ���̺� �����
create table pl_test(
no number , name varchar2(20) , addr varchar2(50));

select * from pl_test;

DECLARE
  v_no number := '&NO';
  v_name varchar2(20) := '&NAME';
  v_addr varchar2(50) := '&ADDR';
BEGIN
  insert into pl_test(no,name,addr)
  values(v_no , v_name , v_addr);
  commit;
END;

select * from pl_test;  
--���� �����ϱ�(Ÿ��)
--1.1 Ÿ�� : v_empno number(10)
--1.2 Ÿ�� : v_empno emp.empno%TYPE  (emp ���̺��� �ִ� empno �÷��� Ÿ�� ���)
--1.3 Ÿ�� : v_row emp%ROWTYPE (v_row ������ emp ���̺� ��� �÷� Ÿ�� ����)

--QUIZ
--�ΰ��� ������ �Է¹޾Ƽ� �� ���� ���

DECLARE
  v_no1 number := '&no1';
  v_no2 number := '&no2';
  result number;
BEGIN
    result := v_no1 + v_no2;
    DBMS_OUTPUT.PUT_LINE('result : ' || result);
END;

--------------------------------------------------------------------------------
DECLARE
  v_emprow emp%ROWTYPE; 
BEGIN
  select *
    into v_emprow --  [empno , ename , ,..... deptno]
  from emp
  where empno=7788;
  
  DBMS_OUTPUT.PUT_LINE(v_emprow.empno || '-' || v_emprow.ename);
END;

--------------------------------------------------------------------------------
create sequence empno_seq
increment by 1
start with 8000
maxvalue 9999
nocycle
nocache;

create table empdml
(
  empno number,
  ename varchar2(20)
);

desc empdml;

DECLARE
  v_empno emp.empno%TYPE;
BEGIN
  select empno_seq.nextval
   into v_empno
  from dual;
  
  insert into empdml(empno ,ename)
  values(v_empno,'ȫ�浿');
  commit;
END;

select * from empdml;
--������� ���� ���� , Ÿ�� , �� �Ҵ�
--------------------------------------------------------------------------------
--pl-sql ���
DECLARE
  vempno emp.empno%TYPE;
  vename emp.ename%TYPE;
  vdeptno emp.deptno%TYPE;
  vname varchar2(20) := null;
BEGIN
  select empno , ename , deptno
    into vempno , vename , vdeptno
  from emp
  where empno=7788;
  --��� if(���ǹ�){���๮}
  IF(vdeptno = 10) THEN vname := 'ACC'; -- if(vdeptno==10) { vname = "ACC"} else if(){}
    ELSIF(vdeptno=20) THEN vname := 'IT';
    ELSIF(vdeptno=30) THEN vname := 'SALES';
  END IF;
  DBMS_OUTPUT.PUT_LINE('����� ������ : ' || vname);
END;

--IF() THEN ���๮
--ELSIF() THEN ���๮
--ELSE ���๮
--END IF
--����� 7788���� ����� ��� , �̸� , �޿��� ������ ���
--������ ��� �޿��� 2000 �̻��̸� '����� �޿��� BIG' ����ϰ�
--�׷��� ������(ELSE) '����� �޿��� SMALL' �̶�� ����ϼ���

DECLARE
  vempno emp.empno%TYPE;
  vename emp.ename%TYPE;
  vsal   emp.sal%TYPE;
BEGIN
  select empno , ename , sal
    into vempno , vename , vsal
  from emp
  where empno=7788;
  --��� if(���ǹ�){���๮}
    IF(vsal >  2000) THEN 
         DBMS_OUTPUT.PUT_LINE('����� �޿��� BIG ' || vsal);
    ELSE
         DBMS_OUTPUT.PUT_LINE('����� �޿��� SMALL ' || vsal);
    END IF;
 END;
 
 -------------------------------------------------------------------------------
 --CASE 
DECLARE
  vempno emp.empno%TYPE;
  vename emp.ename%TYPE;
  vdeptno emp.deptno%TYPE;
  v_name varchar2(20);
BEGIN
     select empno, ename , deptno
        into vempno, vename , vdeptno
     from emp
     where empno=7788;
     
--    v_name := CASE vdeptno
--                WHEN 10  THEN 'AA'
--                WHEN 20  THEN 'BB'
--                WHEN 30  THEN 'CC'
--                WHEN 40  THEN 'DD'
--              END;

    v_name := CASE 
                WHEN vdeptno=10  THEN 'AA'
                WHEN vdeptno in(20,30)  THEN 'BB'
                WHEN vdeptno=40  THEN 'CC'
                ELSE 'NOT'
              END;
    DBMS_OUTPUT.PUT_LINE('����� �μ���:' || v_name);            
END;
--------------------------------------------------------------------------------
--pl-sql (�ݺ���)
--Basic loop
/*
LOOP
  ����;
  EXIT WHEN (���ǽ�)
END LOOP
*/
DECLARE
  n number :=0;
BEGIN
  LOOP
    DBMS_OUTPUT.PUT_LINE('n value : ' || n);
    n := n + 1;
    EXIT WHEN n > 5;
  END LOOP;
END;

/*
WHILE(n < 6)
LOOP
   ���๮;
END LOOP
*/
DECLARE
  num number := 0;
BEGIN
  WHILE(num < 6)
  LOOP
    DBMS_OUTPUT.PUT_LINE('num �� : ' || num);
    num := num +1;
  END LOOP;
END;

--for
--java for(int i = 0 ; i < 10 ; i++) {}
BEGIN
  FOR i IN 0..10 LOOP
    DBMS_OUTPUT.PUT_LINE(i);
  END LOOP;
END;

--�� FOR ���� ����ؼ� (1~100���� ��) ���ϼ���
DECLARE
total number :=0;
BEGIN
  FOR i IN 1..100 LOOP
    total := total + i;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('1~100 ���� : ' || total);
END;

--11g ���� (continue (x))
--11g (continue �߰�)
DECLARE
  total number := 0;
BEGIN
  FOR i IN 1..100 LOOP
    DBMS_OUTPUT.PUT_LINE('���� : ' || i);
    CONTINUE WHEN i > 5; --skip
    total := total + i; -- 1 , 2 , 3 , 4, 5
  END LOOP;
    DBMS_OUTPUT.PUT_LINE('�հ� : ' || total);
END;
--------------------------------------------------------------------------------
--Ȱ��
DECLARE
  v_empno emp.empno%TYPE;
  v_name  emp.ename%TYPE := UPPER('&name');
  v_sal   emp.sal%TYPE;
  v_job   emp.job%TYPE;
BEGIN
  select empno , job ,sal
    into v_empno, v_job , v_sal
  from emp
  where ename = v_name;
  
  IF v_job IN('MANAGER','ANALYST') THEN
     v_sal := v_sal * 1.5;
  ELSE
     v_sal := v_sal * 1.2;
  END IF;
  
  update emp
  set sal = v_sal
  where empno=v_empno;
  
  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT || '���� ���� ���� �Ǿ����ϴ�');
  
  --����ó��
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
       DBMS_OUTPUT.PUT_LINE(v_name || '�� �ڷᰡ �����ϴ�');
    WHEN TOO_MANY_ROWS THEN
       DBMS_OUTPUT.PUT_LINE(v_name || '�� ���� �����Դϴ�');
    WHEN OTHERS THEN
       DBMS_OUTPUT.PUT_LINE('��Ÿ ������ �߻��߽��ϴ�');
END;
/*
���Ǵ� �ϳ��� �ุ RETURN �ؾ� �մϴ�. PL/SQL ���� ���� SELECT ������ ���� ��Ģ��
�����ϴ� Embedded SQL �� ANSI ���ֿ� ���մϴ�. ������ ����� �ϳ��� �ุ�� RETURN ��
��  �ϰ�  �ϳ���  ��  �̻�  �Ǵ�  ����  ����  ����  ������  �����մϴ�.  PL/SQL ��
NO_DATA_FOUND �� TOO_MANY_ROWS �� ���ܷ� ������ ���� ���ǿ��� ������ �� �ִ� ǥ�� ��
�ܸ� �����Ͽ� ó�� �մϴ�.
*/

select * from emp;
select * from emp where ename='SMITH';
rollback;

-- pl-sql �⺻ ����  END
--------------------------------------------------------------------------------
-- cursor , procedure , function , Trigger �����ڿ� 

--[ Ŀ�� ]
--���ݱ��� ���� ������ ������ ó�� (��ü row�� �������)

--[CURSOR]
--1.  [�����]�� �����͸� ó���ϴ� ����� ����
--2.  �������� �����͸� ó���ϴ� ó���ϴ� ����� ���� (�� ���̻���  row������ ���)
 
--����޿����̺�(�Ǽ�ȸ��)
--������ , �Ͽ��� ,�ð��� 

--��� , �̸� , ������ ,   ���� , �ð� , �ð��� , �Ĵ�
-- 10   ȫ�浿  ������   120    null   null     null
-- 11   ������  �ð���   null   10      100     null
-- 12   �̼���  �Ͽ���   null   null    120     10

--������
--����
--
--�Ͽ���
--�ð� , �ð���
--
--�ð���
--�ð��� , �Ĵ�


--�� ��ľ� �����ؼ� ������ �������� �����

--if ������  > ���� (�ѱ޿�)
--elsif �ð��� > �ð� * �ð��� (�ѱ޿�)
--elsif �Ͽ��� > �ð��� + �Ĵ� (�ѱ޿�)
 
 
 
--SQL CURSOR �� �Ӽ��� ����Ͽ� SQL ������ ����� �׽�Ʈ�� �� �ִ�.
--[�� �� �� ��]
  --SQL%ROWCOUNT ���� �ֱ��� SQL ���忡 ���� ������ ���� ���� ��
  --SQL%FOUND ���� �ֱ��� SQL ������ �ϳ� �Ǵ� �� �̻��� �࿡ ������ ��ģ�ٸ� TRUE �� ���Ѵ�.
  --SQL%NOTFOUND ���� �ֱ��� SQL ������ � �࿡�� ������ ��ġ�� �ʾҴٸ� TRUE ��  ���Ѵ�.
  --SQL%ISOPEN PL/SQL �� ����� �Ŀ� ��� �Ͻ��� Ŀ���� �ݱ� ������ �׻� FALSE �� �򰡵ȴ�.
  
/*
   DECLARE
          CURSOR Ŀ���̸� IS ����(Ŀ���� ������ ����)
   BEGIN
         OPEN Ŀ���̸� (Ŀ���� ������ �ִ� ������ ����)
             
         FETCH Ŀ���̸� INTO ��������...
          --Ŀ���� ���� �����͸� �о ���ϴ� ������ ����
         CLOSE Ŀ���̸� (Ŀ���ݱ�) 
   END


*/
DECLARE
  vempno emp.empno%TYPE;
  vename emp.ename%TYPE;
  vsal   emp.sal%TYPE;
  CURSOR c1  IS select empno,ename,sal from emp where deptno=30;
BEGIN
    OPEN c1; --Ŀ���� ������ �ִ� ���� ����
    LOOP
      --Memory
      /*
        7499 ALLEN 1600
        7521 WARD 1250
        7654 MARTIN 1250
        7698 BLAKE 2850
        7844 TURNER 1500
        7900 JAMES 950
      */
      FETCH c1 INTO vempno , vename, vsal;
      EXIT WHEN c1%NOTFOUND; --���̻� row �� ������ Ż��
        DBMS_OUTPUT.PUT_LINE(vempno || '-' || vename || '-'|| vsal);
    END LOOP;
    CLOSE c1;
END;
-------------------------------------------------------
--�� ǥ���� �� �� �����ϰ�
--java (for(emp e : emplist){}
DECLARE
  CURSOR emp_curr IS  select empno ,ename from emp;
BEGIN
   
    FOR emp_record IN emp_curr  --row ������ emp_record���� �Ҵ�
    LOOP
      EXIT WHEN  emp_curr%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(emp_record.empno || '-' || emp_record.ename);
    END LOOP;
   
    CLOSE emp_curr;
END;

--------------------------------------------------------------------------------
DECLARE
  vemp emp%ROWTYPE; --Type ����
  CURSOR emp_curr IS  select empno ,ename from emp;
BEGIN
  FOR vemp IN emp_curr  --row ������ emp_record���� �Ҵ�
    LOOP
      EXIT WHEN  emp_curr%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(vemp.empno || '-' || vemp.ename);
    END LOOP;
    CLOSE emp_curr;
END;
-------------------------------------------------
DECLARE
  v_sal_total NUMBER(10,2) := 0;
  CURSOR emp_cursor
  IS SELECT empno,ename,sal FROM emp
     WHERE deptno = 20 AND job = 'CLERK'
     ORDER BY empno;
BEGIN
  DBMS_OUTPUT.PUT_LINE('��� �� �� �� ��');
  DBMS_OUTPUT.PUT_LINE('---- ---------- ----------------');
  FOR emp_record IN emp_cursor 
  LOOP
      v_sal_total := v_sal_total + emp_record.sal;
      DBMS_OUTPUT.PUT_LINE(RPAD(emp_record.empno,6) || RPAD(emp_record.ename,12) ||
                           LPAD(TO_CHAR(emp_record.sal,'$99,999,990.00'),16));
  END LOOP;
      DBMS_OUTPUT.PUT_LINE('----------------------------------');
      DBMS_OUTPUT.PUT_LINE(RPAD(TO_CHAR(20),2) || '�� �μ��� �� ' ||
      LPAD(TO_CHAR(v_sal_total,'$99,999,990.00'),16));
END;

--------------------------------------------------------------------------------
create table cursor_table
as
  select * from emp where 1=2;

select* from cursor_table;  

alter table cursor_table
add totalsum number;

desc cursor_table;

--����
--emp ���̺�����  �������  ��� , �̸� , �޿��� ������
--�ͼ� cursor_table insert �� �ϴµ� totalsum �� �޿� + comm ���ؼ�
--�μ���ȣ�� 10�� ����� totalsum�� �޿� ������ ��������
--������ ó��
--
insert into CURSOR_TABLE(empno,ename,sal,totalsum)
  select empno , ename , sal , sal+nvl(comm,0)
  from emp where deptno=20;
  
rollback;
select *  from CURSOR_TABLE;

DECLARE
  result number := 0;
  CURSOR emp_curr IS select empno, ename, sal,deptno,comm from emp;
  BEGIN
    FOR vemp IN emp_curr   --row ������ emp_record ������ �Ҵ�
    LOOP
        EXIT WHEN emp_curr%NOTFOUND;
        IF(vemp.deptno = 20) THEN 
              result := vemp.sal+nvl(vemp.comm,0);
              insert into cursor_table(empno, ename, sal,deptno,comm,totalsum) 
              values (vemp.empno,vemp.ename, vemp.sal,vemp.deptno,vemp.comm,result);
        ELSIF(vemp.deptno = 10) THEN 
            result := vemp.sal;
              insert into cursor_table(empno, ename, sal,deptno,comm,totalsum) 
              values (vemp.empno,vemp.ename, vemp.sal,vemp.deptno,vemp.comm,result);
        ELSE
            DBMS_OUTPUT.PUT_LINE('ETC');
        END IF;
     END LOOP;   
  END;

rollback;
commit;


select * from cursor_table order by deptno;

--ArrayList<Emp> cursor_table = new ArrayLIst<Emp>();

--for(Emp e : cursor_table){
-- if(e.deptno == 10 
--}



--PL-SQL Ʈ����� �� ���� ó���ϱ�
 DECLARE
    v_ename emp.ename%TYPE := '&p_ename';
    v_err_code NUMBER;
    v_err_msg VARCHAR2(255);
    BEGIN
          DELETE emp WHERE ename = v_ename;
          IF SQL%NOTFOUND THEN
              RAISE_APPLICATION_ERROR(-20001,'my no data found'); --����ڰ� ���� �����
          END IF;
       EXCEPTION 
        WHEN OTHERS THEN
            ROLLBACK;
              v_err_code := SQLCODE;
              v_err_msg := SQLERRM;
              DBMS_OUTPUT.PUT_LINE('���� ��ȣ : ' || TO_CHAR(v_err_code));
              DBMS_OUTPUT.PUT_LINE('���� ���� : ' || v_err_msg);
      END;
        
select * from emp where ename ='KING';

delete from emp where ename='aaa';
--------------------------------------------------------------------------------
--���ݱ��� ������� �۾��� ���������� ���� ���� �ʾҴ�
--crerate table , create view 
--���� ������ ���� Ŀ���� ���������� ���� (��ü)
--��ü ���·� ���� �س����� �� �������� �ڵ����� �ʰ� �ҷ� ���

--Oracle : subprogram(procedure)
--Ms-sql : procedure

--���� ���Ǵ� ������ ���ȭ ���Ѽ� ��ü�� �����ϰ�
--�ʿ��� ������ �ҷ�(ȣ��) �ؼ� ����ϰڴ�

create or replace procedure usp_emplist
is
  BEGIN
    update emp
    set job = 'TTT'
    where deptno=30;
  END;

--������
execute usp_emplist;
select * from emp where deptno=30;
rollback;

--procedure  ����
--���� : APP(emp.java > select .... ����)    ->��Ʈ��ũ > DB���� > selet... > DB��
--���� : APP(emp.java > usp_emplist ����)    ->��Ʈ��ũ > DB���� > usp_emplist > DB��

--1.���� : ��Ʈ��ũ Ʈ���� ����(�ð� ����)
--2.���� : ���� (��Ʈ��ũ �󿡼� ...���� ���)�ذ�


--procedure 
--parameter  ��밡��
--���� : INPUT  , OUTPUT
create or replace procedure usp_update_emp
(vempno emp.empno%TYPE)
is
  BEGIN
    update emp
    set sal = 0
    where empno = vempno;
  END;
--������
exec usp_update_emp(7788);

select * from emp where empno = 7788;
rollback;


--void call(int no) { int i =0; }
--------------------------------------------------------------------------------
create or replace procedure usp_getemplist
(vempno emp.empno%TYPE) -- input parameter
is
  --���ο��� ����ϴ� ����
  vname emp.ename%TYPE;
  vsal  emp.sal%TYPE;
  BEGIN
      select ename, sal
        into vname , vsal
      from emp
      where empno=vempno;
      
      DBMS_OUTPUT.put_line('�̸��� : ' || vname);
      DBMS_OUTPUT.put_line('�޿��� : ' || vsal);
  END;

exec usp_getemplist(7902);


--int age = call(100); 
--------------------------------------------------------------------------------
-- procedure  �� parameter  ���� 2����
--1. input paramter : ���� �ݵ��  �Է�          (IN : �����ϴ� default)
--2. output parmater : ���� �Է°��� ���� �ʾƿ� (OUT)
create or replace procedure app_get_emplist
(
  vempno IN emp.empno%TYPE,
  vename OUT emp.ename%TYPE,
  vsal   OUT emp.sal%TYPE
)
is
  BEGIN
    select ename, sal
      into vename , vsal
    from emp
    where empno=vempno;
  END;

--����Ŭ ���� �׽�Ʈ
DECLARE
  out_ename emp.ename%TYPE;
  out_sal   emp.sal%TYPE;
BEGIN
   app_get_emplist(7902,out_ename,out_sal);
   DBMS_OUTPUT.put_line('��°� : ' || out_ename || '-' || out_sal);
END;


---------------------�⺻ procedure END-----------------------------------------
--[����� ���� �Լ�]
--to_char() , sum() ����Ŭ���� ����
--����ڰ� ���� �ʿ��� �Լ��� ����� ��밡��
--������� �ٸ� �Լ������� ����
--����� ���� �Լ� paramter  ���� , return ��
create or replace function f_max_sal
(s_deptno emp.deptno%TYPE)
return number   -- public int f_max_sal(int deptno) { int max_sal = 0;  return 10}
is
  max_sal emp.sal%TYPE;
BEGIN
      select max(sal)
        into max_sal
      from emp
      where deptno = s_deptno;
      return max_sal;
END;

---
select * from emp where sal = f_max_sal(10);

select max(sal) , f_max_sal(30) from emp;
--
create or replace function f_callname
(vempno emp.empno%TYPE)
return varchar2 -- public String f_callname(int empno) { return "ȫ�浿"}
is
  v_name emp.ename%TYPE;
BEGIN
    select ename || '��'
      into v_name
    from emp
    where empno=vempno;
    return v_name;
END;

--select f_callname(7788) from dual;

select empno, ename , f_callname(7788) , sal
from emp
where empno=7788;

select empno, ename , f_callname(empno) , sal
from emp
where empno=7788;

--�Լ� 
--parmater  ����� �Է¹޾Ƽ� ����� �ش�Ǵ� �μ��̸��� �����ϴ� �Լ�
create or replace function f_get_dname
(vempno emp.empno%TYPE)
return varchar2
is
    v_dname dept.dname%TYPE;
  BEGIN
    select dname
      into v_dname
    from dept
    where deptno = (select deptno from emp where empno=vempno);
    return v_dname;
  END;

select empno , ename , f_get_dname(empno)
from emp 
where empno=7902;
--------------------------function END------------------------------------------

--[Ʈ���� : Trigger]
--Ʈ����(trigger)�� �������� �ǹ̴� ��Ƽ質 (��Ƽ踦) ���, �߻��ϴ�,
--(�����) ���߽�Ű�ٶ�� �ǹ̰� �ִ�.
 
--[�԰�]    [���]     [���]
 
--insert
--insert into ���
--select * from �԰�

 
 
--�԰� INSERT (���������� [Ʈ�����]�� ����)
--��� INSERT
--����δ� : lock
 
 
--PL/SQL������ Ʈ���� ���� ��Ƽ谡 ������� �ڵ����� �Ѿ��� �߻�ǵ���
--��� �̺�Ʈ�� �߻��ϸ� �׿� ���� �ٸ� �۾��� �ڵ����� ó���Ǵ� ���� �ǹ��Ѵ�.
/*
Ʈ���Ŷ� Ư�� ���̺��� �����Ϳ� ������ �������� �� �ڵ����� ����Ǵ�
[���� ���ν���]��� �� �� �ִ�.
�ռ� ��� ���� ���ν����� �ʿ��� ������ ����ڰ� ����
 EXECUTE ���ɾ�� ȣ���ؾ� �ߴ�.
������ Ʈ���Ŵ� �̿� �޸� ���̺���
�����Ͱ� INSERT, UPDATE, DELETE ���� ���� ����Ǿ��� ��
[ �ڵ����� ����ǹǷ� �� ����� �̿��ϸ� ���� ���� �۾� ] �� �� �� �ִ�.
�̷� ������ Ʈ���Ÿ� ����ڰ� ���� �����ų ���� ����.
 
 
--BEFORE : ���̺����� DML ����Ǳ� ���� Ʈ���Ű� ����
--AFTER :  ���̺����� DML �����Ŀ� Ʈ���� ����
 
Syntax
CREATE [OR REPLACE] TRIGGER trigger_name
{BEFORE | AFTER} triggering_event [OF column1, . . .] ON table_name
[FOR EACH ROW [WHEN trigger_condition]
trigger_body;
 
trigger_name TRIGGER �� �ĺ���
  BEFORE | AFTER DML ������ ����Ǳ� ���� TRIGGER �� ������ ������ �����
  �Ŀ� TRIGGER �� ������ �������� ����
triggering_event 
TRIGGER �� �����ϴ� DML(INSERT,UPDATE,DELETE)���� ����Ѵ�.
 
OF column TRIGGER �� ����Ǵ� ���̺����� COLUMN ���� ����Ѵ�.
 
table_name TRIGGER �� ����Ǵ� ���̺� �̸�
 
FOR EACH ROW �� �ɼ��� ����ϸ� 
�� ���� Ʈ���Ű� �Ǿ� triggering ����
�� ���� ������� �࿡ ���� ���� �ѹ��� �����ϰ� �������
������ ���� ���� Ʈ���Ű� �Ǿ� DML ���� �� �ѹ��� ����ȴ�.
 
 
  TRIGGER ���� OLD �� NEW
    �� ���� TRIGGER ������ ����� �� �ִ� ������ Ʈ���� ������ ���� ó���ǰ� �ִ� ��
    �� �׼����� �� �ִ�. �� �ΰ��� �ǻ� ���ڵ带 ���Ͽ� �� �۾��� ������ �� �ִ�. :OLD
    �� INSERT ���� ���� ���ǵ��� �ʰ� :NEW �� DELETE �� ���� ���ǵ��� �ʴ´�. �׷���
    UPDATE �� :OLD �� :NEW �� ��� �����Ѵ�. �Ʒ��� ǥ�� OLD �� NEW ���� ������ ǥ�̴�. 
    ���� :OLD :NEW
    INSERT ��� �ʵ�� NULL �� ���� ������ ������ �� ���Ե� ���ο� ��
    UPDATE �����ϱ� ���� ���� �� ������ ������ �� ���ŵ� ���ο� ��
    DELETE ���� �����Ǳ� ���� ���� �� ��� �ʵ�� NULL �̴�.
 
DROP TRIGGER ���ɾ�� Ʈ���Ÿ� ������ �� �ְ� TRIGGER �� ��� disable �� �� �ִ�.
DROP TRIGGER trigger_name;
ALTER TRIGGER trigger_name {DISABLE | ENABLE};
TRIGGER �� DATA DICTIONARY
TRIGGER �� ������ �� �ҽ� �ڵ�� ������ ���� VIEW �� user_triggers �� ����ȴ�. ��
VIEW �� TRIGGER_BODY, WHERE ��, Ʈ���Ÿ� ���̺�, TRIGGER Ÿ���� ���� �Ѵ�.
 
*/
create table tri_emp
as
  select empno , ename from emp where 1=2;


select * from tri_emp;

create or replace trigger tri_01
after insert on tri_emp
BEGIN -- �ڵ� ������ ����
    DBMS_OUTPUT.PUT_LINE('���Ի�� �Ի�');
END;


insert into tri_emp
values(1000,'ȫ�⵿');




create or replace trigger tri_02
after update on tri_emp
BEGIN
  DBMS_OUTPUT.PUT_LINE('���Ի�� ����');
END;

--���̺��� trigger ����
select * from user_triggers;


insert into tri_emp values(100,'������');

update tri_emp
set ename='����'
where empno=100;


--delete Ʈ���� : tri_emp
--������̺� ���� (ȭ�� ���)
create or replace trigger tri_03
after delete on tri_emp
BEGIN
  DBMS_OUTPUT.PUT_LINE('���Ի�� ����');
END;

insert into tri_emp values(200,'ȫ�浿');
update tri_emp set ename='����' where empno= 200;
delete from tri_emp where empno=200;

--------------------------------------------------------------------------------
--Ʈ������ Ȱ��
create table tri_order
(
  no number,
  ord_code varchar2(10),
  ord_date date
);

--before Ʈ������ ���۽����� ���� tri_order ���̺� insert �Ǳ� ����
--Ʈ���� ���� ���� �� ���� insert �۾�
create or replace trigger trigger_order
before insert on tri_order
BEGIN
  IF(to_char(sysdate,'HH24:MM') not between '09:00' and '14:00') THEN
     RAISE_APPLICATION_ERROR(-20002, '���ð� ���� ������');
  END IF;
END;

insert into tri_order values(1,'notebook',sysdate);
insert into tri_order values(2,'notebook',sysdate);
select * from tri_order;
commit;

--Ʈ���� ����
drop trigger trigger_order;


--POINT
--PL_SQL �ΰ��� ��������(���̺�) ����
--:OLD > Ʈ���Ű� ó���� ���ڵ��� ���� ���� ���� (ms-sql (deleted)
--:NEW > ������ ����                             (ms-sql (inserted)

create or replace trigger tri_order2
before insert on tri_order
for each row
BEGIN
  IF(:NEW.ord_code) not in('desktop') THEN
     RAISE_APPLICATION_ERROR(-20002, '��ǰ�ڵ� ����');
  END IF;
END;

select * from tri_order;

--���� (desktop)
insert into tri_order values(200,'notebook',sysdate);

insert into tri_order values(200,'desktop',sysdate);

select * from tri_order;
commit;

--------------------------------------------------------------------------------
--�԰� , ���

create table t_01 --�԰�
(
  no number,
  pname varchar2(20)
);

create table t_02 --���
(
  no number,
  pname varchar2(20)
);

--�԰� ������ ������ ���� �����͸� ��� �Է�
create or replace trigger insert_t_01
after insert on t_01
for each row
BEGIN
  insert into t_02(no, pname)
  values(:NEW.no ,:NEW.pname);
END;

--�԰�
insert into t_01 values(1,'notebook');

select * from t_01;
select * from t_02;

-- �԰� ��ǰ�� ���� (��� ����)
create or replace trigger update_t_01
after update on t_01
for each row
BEGIN
  update t_02
  set pname = :NEW.pname
  where no = :OLD.no;
END;

update t_01
set pname = 'notebook2'
where no = 1;

select * from t_01;

select * from t_02;

--delete Ʈ���� ����� ������ 
--�԰� ������ delete from t_01 where no =1 ���� �Ǹ� ��� ����
create or replace trigger delete_tri_01
after delete on t_01
for each row
BEGIN
  delete from t_02
  where no=:OLD.no;
END;

delete from t_01 where no=1;

select* from t_01;
select* from t_02;

commit;
--------------------------------------------------------------------------------
-- �����ߴ� ��� ��� ---------------------------------------------------------------------


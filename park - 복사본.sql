--alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

select * from emp;

select * from dept;

select * from salgrade;

create view v_001
as
 select empno, ename from emp;
 
 -- �����ȣ, �̸�, �޿�, �μ���ȣ, �μ���, ����޿� ����� ��� view 
create or replace view v_emp
as
  select e.empno, e.ename, e.sal, e.deptno, d.dname, s.GRADE
  from emp e join dept d
  on e.deptno = d.deptno
  join salgrade s
  on e.sal between s.losal and s.hisal;
  
select * from v_emp;
  
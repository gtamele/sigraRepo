<!-- Chamada da taglib [bloco - campoData] -->
<%@ attribute name="id" required="true"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="value" required="true"%>
<input type="text" readonly="readonly" id="${id}" name="${id}" value="${value}" style=" width : 350px;" />
<script type="text/javascript">
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yy',changeMonth: true, changeYear: true, showWeek: true	});
</script>

<!DOCTYPE html>
<html>

<head>
    <title>Employee</title>
</head>

<body>
    <div align = "center" id="emp">
        <form method="post">
            <table>
                <tr>
                    <td>Employee Id</td>
                    <td>
                        <input type="number" name="empid">
                    </td>
                </tr>
                <tr>
                    <td>Employee Name</td>
                    <td>
                        <input type="text" name="empname">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2">
                        <input type="submit" name="add" value="Save Employee">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div>
        ${map}
    </div>
</body>

</html>
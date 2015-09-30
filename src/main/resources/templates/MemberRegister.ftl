<#import "/spring.ftl" as spring />
<html lang="en">


<body>


<div class="row">
    <form class="col s6 offset-s3" method="post" action="<@spring.url "/member/register" />">

        <div class="row" style="margin-top:2em">
            <div class="input-field col s6">
                <input type="text" name="login" value="">
                <label>Nickname</label>
            </div>
            <div class="input-field col s6">
                <input type="text" name="mail" value="">
                <label>Email</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s6">
                <input type="text" name="pass" value="">
                <label>Password</label>
            </div>
            <div class="input-field col s6">
                <input type="text" name="confPass" value="">
                <label>Confirm password</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <input type="text" name="location" value="">
                <label>Location</label>
            </div>
            <div class="input-field col s6">
                <select name="gender">
                    <option value="A">Any</option>
                    <option value="F">Female</option>
                    <option value="M">Male</option>
                </select>
                <label>Gender</label>
            </div>
        </div>

        <button type="submit" class="waves-effect waves-light btn red right"
                style="margin-top:2em">
            Register
        </button>

    </form>
</div>


</body>
</html>
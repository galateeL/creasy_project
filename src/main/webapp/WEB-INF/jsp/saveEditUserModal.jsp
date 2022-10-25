<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<div class="modal fade" id="DisconnectWhenEdit" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Approuve</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>you must reconnect if you validate.</p>
            </div>
            <div class="modal-footer">
                <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/edit"
                      modelAttribute="updateUser">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Abandon</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" value="Save" class="btn btn-primary border-0" style="
                    background-color: #FFC900;">Confirm</button>
                </form>
            </div>
        </div>
    </div>
</div>
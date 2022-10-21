<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<div class="modal fade" id="noteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add new note</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Add note</p>
            </div>
            <div class="modal-footer">
                <form action="${pageContext.request.contextPath}/partners/${partner.id}/add-note" method="post">

                    <label for="note" class="form-label">Note</label>
                    <textarea name="exchange" rows="12" cols="35" id="note" placeholder="Tap your note here..." ></textarea>

                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Abandon</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary">Save</button>

                </form>
            </div>
        </div>
    </div>
</div>
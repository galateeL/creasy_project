<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<div class="modal fade" id="eventModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add new note</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Add Event</p>
            </div>
            <div class="modal-footer">
                <form action="${pageContext.request.contextPath}/${partner.id}/add-event" method="post">

                    <label for="title" class="form-label">title</label>
                    <input name="title" rows="12" cols="35" id="title" placeholder="Tap your note here..." >

                    <label for="description" class="form-label">description</label>
                    <input name="description" rows="12" cols="35" id="description" placeholder="Tap your note here..." >

                    <label for="start">Start Date:</label>
                    <input type="datetime-local" id="start" name="start">

                    <label for="finish">Finish Date:</label>
                    <input type="datetime-local" id="finish" name="finish">

                    <label for="address" class="form-label">Address</label>
                    <input name="address" rows="12" cols="35" id="address" placeholder="Tap your note here..." >

                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Abandon</button>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary">Save</button>

                </form>
            </div>
        </div>
    </div>
</div>
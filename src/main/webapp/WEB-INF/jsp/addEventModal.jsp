<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<div class="modal fade" id="eventModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add new event</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-footer justify-content-center col-12">
                <form class="d-flex flex-column col-10" action="${pageContext.request.contextPath}/${partner.id}/add-event" method="post">

                    <label for="title" class="form-label p-1">title</label>
                    <input class="form-control" name="title" id="title" placeholder="Tap your title here..." >

                    <label for="description" class="form-label mt-3 p-1">description</label>
                    <input class="form-control" name="description"  id="description" placeholder="Tap your description here..." >

                    <label class="form-label mt-3 p-1" for="start">Start Date:</label>
                    <input class="form-control" type="datetime-local" id="start" name="start">

                    <label class="form-label mt-3 p-1" for="finish">Finish Date:</label>
                    <input class="form-control" type="datetime-local" id="finish" name="finish">

                    <label for="address" class="form-label mt-3 p-1">Address</label>
                    <input class="form-control" name="address" id="address" placeholder="Tap your Address here..." >

                    <div class="d-flex justify-content-center mt-3">
                        <button type="button" class="btn btn-secondary me-4" data-bs-dismiss="modal">Abandon</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>


                </form>
            </div>
        </div>
    </div>
</div>